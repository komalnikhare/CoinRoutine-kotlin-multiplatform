package org.example.project.coins.domain.usecases

import org.example.project.coins.data.mapper.toCoinModel
import org.example.project.coins.domain.api.CoinsRemoteDataSource
import org.example.project.coins.domain.models.CoinModel
import org.example.project.core.domain.DataError
import org.example.project.core.domain.Result
import org.example.project.core.domain.map

class GetCoinDetailsUseCase(
    private val client: CoinsRemoteDataSource
) {
    suspend fun execute(coinId: String): Result<CoinModel, DataError.Remote> {
        return client.getCoinById(coinId).map { dto ->
            dto.data.coin.toCoinModel()
        }
    }
}