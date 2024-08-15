package favorites.client.data.repository

import favorites.client.data.models.favorites.FavoritesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.http.Query


class FavoritesRepository(private val favoritesServiceApi: FavoritesServiceApi) {

    suspend fun searchFavorites(page: Int, limit: Int, user_session_email: String, query: String): Response<FavoritesResponse> {
        return withContext(Dispatchers.IO){ favoritesServiceApi.searchFavorites(page = page, limit = limit, user_session_email=user_session_email, query=query)}

    }


    suspend fun deleteFavorite(favoriteId: String): Response<Unit> {
        return favoritesServiceApi.deleteFavorite(favoriteId)
    }

}