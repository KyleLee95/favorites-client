package favorites.client.data.repository

import favorites.client.data.models.ArtResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ArtRepository(private val artServiceApi: ArtServiceApi) {

    suspend fun getArtwork(limit: Int, page: Int, query: String, offset: Int, fields: String): Response<ArtResponse> {
        return withContext(Dispatchers.IO) {
            artServiceApi.getArtworks(limit = limit, page=page, q = query, offset=offset, fields = fields)
        }
    }
}
