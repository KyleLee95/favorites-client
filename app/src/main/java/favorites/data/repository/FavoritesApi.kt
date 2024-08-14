package favorites.data.repository

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FavoritesApi {
    @GET(value = "/businesses/search")
    suspend fun getBusinesses(
        @Query("term") term: String,
        @Query("location") location: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): Response<BusinessResponse>
}