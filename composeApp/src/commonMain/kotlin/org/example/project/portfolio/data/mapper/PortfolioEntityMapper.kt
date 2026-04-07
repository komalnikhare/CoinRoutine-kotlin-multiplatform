package org.example.project.portfolio.data.mapper

import kotlinx.datetime.Clock
import org.example.project.core.domain.coin.Coin
import org.example.project.portfolio.data.local.PortfolioCoinEntity
import org.example.project.portfolio.domain.PortfolioCoinModel

fun PortfolioCoinEntity.toPortfolioCoinModel(
    currentPrice: Double
): PortfolioCoinModel{
    return PortfolioCoinModel(
        coin = Coin(
            id = coinId,
            name = name,
            symbol = symbol,
            iconUrl  = iconUrl
        ),
        performancePercent =  ((currentPrice - averagePurchasePrice) / averagePurchasePrice) * 100,
        averagePurchasePrice = averagePurchasePrice,
        ownedAmountInUnit = amountOwned,
        ownedAmountInFiat = amountOwned  * currentPrice
    )
}

fun PortfolioCoinModel.toPortfolioCoinEntity(): PortfolioCoinEntity {
    return PortfolioCoinEntity(
        coinId = coin.id,
        name = coin.name,
        symbol = coin.symbol,
        iconUrl = coin.iconUrl,
        averagePurchasePrice = averagePurchasePrice,
        amountOwned = ownedAmountInUnit,
        timestamp = Clock.System.now().toEpochMilliseconds()
    )
}