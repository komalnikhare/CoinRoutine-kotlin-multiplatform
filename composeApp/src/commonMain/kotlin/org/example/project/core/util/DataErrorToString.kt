package org.example.project.core.util

import coinroutine.composeapp.generated.resources.Res
import coinroutine.composeapp.generated.resources.error_disk_full
import coinroutine.composeapp.generated.resources.error_insufficient_balance
import coinroutine.composeapp.generated.resources.error_no_internet
import coinroutine.composeapp.generated.resources.error_request_timeout
import coinroutine.composeapp.generated.resources.error_serialization
import coinroutine.composeapp.generated.resources.error_too_many_requests
import coinroutine.composeapp.generated.resources.error_unknown
import org.example.project.core.domain.DataError
import org.jetbrains.compose.resources.StringResource

fun DataError.toUiText(): StringResource = when (this) {
    DataError.Local.DISK_FULL -> Res.string.error_disk_full
    DataError.Local.Unknown -> Res.string.error_unknown
    DataError.Remote.REQUEST_TIMEOUT -> Res.string.error_request_timeout
    DataError.Remote.TOO_MANY_REQUESTS -> Res.string.error_too_many_requests
    DataError.Remote.NO_INTERNET -> Res.string.error_no_internet
    DataError.Remote.SERVER_ERROR -> Res.string.error_unknown
    DataError.Remote.SERIALIZATION_ERROR -> Res.string.error_serialization
    DataError.Remote.Unknown -> Res.string.error_unknown
    DataError.Local.INSUFFICIENT_FUNDS -> Res.string.error_insufficient_balance
}