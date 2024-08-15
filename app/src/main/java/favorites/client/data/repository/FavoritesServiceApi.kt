package favorites.client.data.repository

import favorites.client.data.models.artworks.FavoriteRequest
import favorites.client.data.models.favorites.FavoritesResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface FavoritesServiceApi {
    @GET(value = "favorites/")
    suspend fun searchFavorites(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("user_session_email") user_session_email: String,
        @Query("query") query: String,
    ): Response<FavoritesResponse>


    @POST(value = "favorites/")
    suspend fun addFavorite(@Body favoriteRequest: FavoriteRequest): Response<Unit> // Adjust the response type if necessary

    @DELETE("/favorites/{id}")
    suspend fun deleteFavorite(@Path("id") favoriteId: String): Response<Unit>
}