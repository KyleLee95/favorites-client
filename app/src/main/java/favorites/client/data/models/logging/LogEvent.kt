package favorites.client.data.models.logging

// Define your data class for the log event
data class LogEvent(
    val sessionEmail: String,
    val event: String,
    val timestamp: Long
)