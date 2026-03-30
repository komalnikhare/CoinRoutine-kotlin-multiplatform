package org.example.project.core.util

expect fun logDebug(tag: String, message: String)
expect fun logInfo(tag: String, message: String)
expect fun logWarning(tag: String, message: String)
expect fun logError(tag: String, message: String, throwable: Throwable? = null)
