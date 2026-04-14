package org.example.project.coins.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.coins.domain.models.PriceModel
import org.example.project.coins.domain.usecases.GetCoinPriceHistoryUseCase
import org.example.project.coins.domain.usecases.GetCoinsListUseCase
import org.example.project.core.domain.Result
import org.example.project.core.util.formatFiat
import org.example.project.core.util.formatePercentage
import org.example.project.core.util.logError
import org.example.project.core.util.toUiText

class CoinsListViewModel(
    private val getCoinsListUseCase: GetCoinsListUseCase,
    private val getCoinPriceHistoryUseCase: GetCoinPriceHistoryUseCase
): ViewModel() {

    private val _state = MutableStateFlow(CoinsState())
    val state = _state
        .onStart {
            getAllCoins()
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = CoinsState()
        )


    private suspend fun getAllCoins() {
        when(val coinResponse = getCoinsListUseCase.execute()) {
            is Result.Success -> {
                _state.update {
                    CoinsState(
                        coins = coinResponse.data.map { coinItem ->
                            UiCoinListItem(
                                id = coinItem.coin.id,
                                name = coinItem.coin.name,
                                symbol = coinItem.coin.symbol,
                                iconUrl = coinItem.coin.iconUrl,
                                formattedPrice = formatFiat(coinItem.price),
                                formattedChange = formatePercentage(coinItem.change),
                                isPositive = coinItem.change >= 0

                            )
                        }
                    )
                }
            }
            is Result.Error -> {

                logError("CoinsListViewModel", "Error getting coins list: ${coinResponse.error.toString()}")
                _state.update {
                    it.copy(
                        coins = emptyList(),
                        error = coinResponse.error.toUiText()
                    )
                }

            }
        }
    }

    fun onCoinLongPressed(coinId: String){
        _state.update {
            it.copy(
                chartState = UiChartState(
                    sparkLine = emptyList(),
                    isLoading = true,
                )
            )
        }

        viewModelScope.launch {
            when(val priceHistory  = getCoinPriceHistoryUseCase.execute(coinId)) {
                is Result.Success ->{
                    _state.update { currentState ->
                        currentState.copy(
                            chartState = UiChartState(
                                sparkLine = priceHistory.data.sortedBy { it.timestamp }.map(PriceModel::price),
                                isLoading = false,
                                coinName = _state.value.coins.find { it.id == coinId }?.name.orEmpty()
                            )
                        )
                    }
                }
                is Result.Error -> {
                    _state.update { currentState ->
                        currentState.copy(
                            chartState = UiChartState(
                                sparkLine = emptyList(),
                                isLoading = false,
                                coinName = ""
                            ),
                            error = priceHistory.error.toUiText()
                        )
                    }
                }
            }
        }
    }
    fun onDismissChart() {
        _state.update {
            it.copy(chartState = null)
        }
    }

}