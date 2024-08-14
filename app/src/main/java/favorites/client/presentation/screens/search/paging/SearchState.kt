package favorites.client.presentation.screens.search.paging

import androidx.paging.PagingData
import favorites.client.data.models.Datum
import kotlinx.coroutines.flow.Flow
data class SearchState(
    val searchOperation: SearchOperation = SearchOperation.INITIAL,
    val data: Flow<PagingData<Datum>>? = null
)

enum class SearchOperation { LOADING, INITIAL, DONE }
