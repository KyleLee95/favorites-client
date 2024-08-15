package favorites.client.presentation.screens.search.paging

import androidx.paging.PagingData
import favorites.client.data.models.artworks.Datum
import favorites.client.data.models.favorites.Favorite
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchOperation: SearchOperation = SearchOperation.INITIAL,
    val data: Flow<PagingData<Datum>>? = null
)


data class FavoritesSearchState(
    val searchOperation: SearchOperation = SearchOperation.INITIAL,
    val data: Flow<PagingData<Favorite>>? = null
)


enum class SearchOperation { LOADING, INITIAL, DONE }
