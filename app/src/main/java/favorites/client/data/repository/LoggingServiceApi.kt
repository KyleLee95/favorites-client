package favorites.client.data.repository
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query


interface LoggingServiceApi {

    @POST(value = "/")
    suspend fun postEventToLog(
//        @Query()
    )
}



//interface FavoritesServiceApi {
//    @GET(value = "/businesses/search")
//    suspend fun getBusinesses(
//        @Query("term") term: String,
//        @Query("location") location: String,
//        @Query("limit") limit: Int,
//        @Query("offset") offset: Int,
//    ): Response<>
//}