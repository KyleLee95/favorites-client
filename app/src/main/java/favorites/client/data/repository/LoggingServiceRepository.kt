package favorites.client.data.repository

import favorites.client.data.models.logging.LogEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoggingServiceRepository (private val loggingServiceApi: LoggingServiceApi){
    suspend fun logEvent(sessionEmail: String, event: String, timestamp: Long) : Response<LogEvent>{
        return withContext(Dispatchers.IO){
            loggingServiceApi.logEvent(LogEvent(sessionEmail=sessionEmail, event = event, timestamp=timestamp))
        }



    }
}