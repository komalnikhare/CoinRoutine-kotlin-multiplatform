package org.example.project.core.util

expect fun formatFail(amount: Double, showDecimal: Boolean = true): String

expect fun formatCoinUnit(amount: Double, symbol: String): String

expect fun formatePercentage(amount: Double): String