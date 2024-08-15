package favorites.client.data.repository

import favorites.client.data.models.logging.LogEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import kotlin.math.log

class LoggingServiceRepository (private val loggingServiceApi: LoggingServiceApi){
    suspend fun logEvent(logEvent: LogEvent): Response<LogEvent>{
        return withContext(Dispatchers.IO){
            loggingServiceApi.logEvent(logEvent)
        }
    }
}