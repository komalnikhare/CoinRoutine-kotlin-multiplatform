package org.example.project.portfolio.data

import androidx.sqlite.SQLiteException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import org.example.project.coins.domain.api.CoinsRemoteDataSource
import org.example.project.core.domain.DataError
import org.example.project.core.domain.EmptyResult
import org.example.project.core.domain.Result
import org.example.project.core.domain.onError
import org.example.project.core.domain.onSuccess
import org.example.project.portfolio.data.local.PortfolioDao
import org.example.project.portfolio.data.local.UserBalanceDao
import org.example.project.portfolio.data.local.UserBalanceEntity
import org.example.project.portfolio.data.mapper.toPortfolioCoinEntity
import org.example.project.portfolio.data.mapper.toPortfolioCoinModel
import org.example.project.portfolio.domain.PortfolioCoinModel
import org.example.project.portfolio.domain.PortfolioRepository

class PortfolioRepositoryImpl(
    private val portfolioDao: PortfolioDao,
    private val userBalanceDao: UserBalanceDao,
    private val coinsRemoteDataSource: CoinsRemoteDataSource
) : PortfolioRepository {

    override suspend fun initializeBalance() {
        val cashBalance = userBalanceDao.getCashBalance()
        if (cashBalance == null) {
            userBalanceDao.insertBalance(
                UserBalanceEntity(cashBalance = 10000.0)
            )
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun allPortfolioCoinsFlow(): Flow<Result<List<PortfolioCoinModel>, DataError.Remote>> {
        return portfolioDao.getAllOwnedCoins().flatMapLatest { portfolioCoinsEntities ->
            if (portfolioCoinsEntities.isEmpty()) {
                flow { emit(Result.Success(emptyList<PortfolioCoinModel>())) }
            } else {
                flow {
                    coinsRemoteDataSource.getListOfCoins()
                        .onError { error ->
                            emit(Result.Error(error))
                        }
                        .onSuccess { coinsDto ->
                            val portfolioCoins =
                                portfolioCoinsEntities.mapNotNull { portfolioCoinsEntity ->
                                    val coin =
                                        coinsDto.data.coins.find { it.uuid == portfolioCoinsEntity.coinId }
                                    coin?.let {
                                        portfolioCoinsEntity.toPortfolioCoinModel(it.price)
                                    }
                                }
                            emit(Result.Success(portfolioCoins))
                        }
                }
            }
        }.catch {
            emit(Result.Error(DataError.Remote.Unknown))
        }
    }

    override suspend fun getPortfolioCoin(coinId: String): Result<PortfolioCoinModel?, DataError.Remote> {
        coinsRemoteDataSource.getCoinById(coinId)
            .onError { error ->
                return Result.Error(error)
            }
            .onSuccess { coinDto ->
                val profileCoinEntity = portfolioDao.getCoinById(coinId)
                return if (profileCoinEntity != null) {
                    Result.Success(profileCoinEntity.toPortfolioCoinModel(coinDto.data.coin.price))
                } else {
                    Result.Success(null)
                }
            }
        return Result.Error(DataError.Remote.Unknown)
    }

    override suspend fun savePortfolioCoin(portfolioCoin: PortfolioCoinModel): EmptyResult<DataError.Local> {
        return try {

            portfolioDao.insert(portfolioCoin.toPortfolioCoinEntity())
            Result.Success(Unit)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun removeCoinFromPortfolio(coinId: String) {
        portfolioDao.deletePortfolioItem(coinId)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun calculateTotalPortfolioValue(): Flow<Result<Double, DataError.Remote>> {
        return portfolioDao.getAllOwnedCoins().flatMapLatest { portfolioCoinsEntities ->
            if (portfolioCoinsEntities.isEmpty()) {
                flow { emit(Result.Success(0.0)) }
            } else {
                flow {
                    coinsRemoteDataSource.getListOfCoins()
                        .onError { error ->
                            emit(Result.Error(error))
                        }
                        .onSuccess { coinsDto ->
                            val totalValue = portfolioCoinsEntities.sumOf { portfolioCoinEntity ->
                                val coin =
                                    coinsDto.data.coins.find { it.uuid == portfolioCoinEntity.coinId }
                                coin?.let {
                                    portfolioCoinEntity.amountOwned * it.price
                                } ?: 0.0
                            }
                            emit(Result.Success(totalValue))
                        }
                }
            }
        }.catch {
            emit(Result.Error(DataError.Remote.Unknown))
        }
    }

    override fun cashBalanceFlow(): Flow<Double> {
        return flow {
            emit(userBalanceDao.getCashBalance() ?: 10000.0)
        }
    }

    override fun totalBalanceFlow(): Flow<Result<Double, DataError.Remote>> {
        return combine(
            cashBalanceFlow(),
            calculateTotalPortfolioValue()
        ){ cashBalance, portfolioResult ->
            when(portfolioResult){
                is Result.Success -> Result.Success(cashBalance + portfolioResult.data)
                is Result.Error -> Result.Error(portfolioResult.error)
            }

        }
    }

    override suspend fun updateCashBalance(newBalance: Double) {
        userBalanceDao.updateCashBalance(newBalance)
    }
}