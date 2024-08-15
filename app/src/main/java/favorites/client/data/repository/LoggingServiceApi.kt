package favorites.client.data.repository
import favorites.client.data.models.logging.LogEvent
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response

// Define your Retrofit API service
interface LoggingServiceApi {
    @POST("logs/")
    suspend fun logEvent(@Body logEvent: LogEvent): Response<LogEvent>
}
