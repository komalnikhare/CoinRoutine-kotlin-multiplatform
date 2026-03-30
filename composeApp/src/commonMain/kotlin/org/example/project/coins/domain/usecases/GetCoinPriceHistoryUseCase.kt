package org.example.project.coins.domain.usecases

import org.example.project.coins.data.mapper.toPriceModel
import org.example.project.coins.domain.api.CoinsRemoteDataSource
import org.example.project.coins.domain.models.PriceModel
import org.example.project.core.domain.DataError
import org.example.project.core.domain.Result
import org.example.project.core.domain.map

class GetCoinPriceHistoryUseCase(
    private val client: CoinsRemoteDataSource
) {
    suspend fun execute(coinId: String): Result<List<PriceModel>, DataError.Remote> {

        return client.getPriceHistory(coinId).map { dto ->
            dto.data.history.map { it.toPriceModel() }
        }
    }
}