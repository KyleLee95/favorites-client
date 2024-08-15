package favorites.client.data.repository

import favorites.client.data.models.favorites.FavoritesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FavoritesServiceApi {
    @GET(value = "favorites/")
    suspend fun getFavorites(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
    ): Response<FavoritesResponse>
}