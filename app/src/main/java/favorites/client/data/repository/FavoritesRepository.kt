package favorites.client.data.repository

import favorites.client.data.models.favorites.FavoritesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response



class FavoritesRepository(private val favoritesServiceApi: FavoritesServiceApi) {

    suspend fun getFavorites(page: Int, limit: Int): Response<FavoritesResponse> {
        return withContext(Dispatchers.IO){ favoritesServiceApi.getFavorites(page = page, limit = limit)}
    }
}