package favorites.client.data.repository

import favorites.client.data.models.ArtResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ArtRepository(private val artServiceApi: ArtServiceApi) {

    // get "page" of pokemon. A list that's offset by the amount of pokemona already loaded
    suspend fun getArtwork(limit: Int, page: Int, query: String): Response<ArtResponse> {
        return withContext(Dispatchers.IO) {
            artServiceApi.getArtworks(limit = limit, page=page, q = query)
        }
    }
}
