package org.example.project

import androidx.compose.runtime.*
import org.example.project.coins.presentation.CoinsListScreen
import org.example.project.portfolio.presentation.PortfolioScreen

import org.example.project.theme.CoinRoutineTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    CoinRoutineTheme {
        //CoinsListScreen {  }
        PortfolioScreen(
            onCoinItemClicked = {},
            onDiscoverCoinsClicked = {}
        )
    }
}