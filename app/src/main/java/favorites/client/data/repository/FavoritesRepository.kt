package favorites.client.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class FavoritesRepository(private val favoritesServiceApi: FavoritesServiceApi) {

    suspend fun getFavorites(
        location: String,
        term: String,
        offset: Int,
        limit: Int,
    ): Response<FavoritesResponse> {
        return withContext(Dispatchers.IO) {
            favoritesServiceApi.getBusinesses(
                location = location,
                term = term,
                offset = offset,
                limit = limit
            )
        }
    }
}
//}

//    suspend fun getFavorites(
//        location: String,
//        term: String,
//        offset: Int,
//        limit: Int,
//    ): Response<FavoritesResponse> {
//        return withContext(Dispatchers.IO) {
//            businessApi.getBusinesses(
//                location = location,
//                term = term,
//                offset = offset,
//                limit = limit
//            )
//        }
//    }
}