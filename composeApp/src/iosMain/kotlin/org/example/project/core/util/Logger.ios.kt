package org.example.project.core.util

import platform.Foundation.NSLog
import platform.Foundation.NSLog

actual fun logDebug(tag: String, message: String) {
    NSLog("[DEBUG] $tag: $message")
}

actual fun logInfo(tag: String, message: String) {
    NSLog("[INFO] $tag: $message")
}

actual fun logWarning(tag: String, message: String) {
    NSLog("[WARNING] $tag: $message")
}

actual fun logError(tag: String, message: String, throwable: Throwable?) {
    val errorMessage = if (throwable != null) {
        "$message - ${throwable.message}"
    } else {
        message
    }
    NSLog("[ERROR] $tag: $errorMessage")
}
