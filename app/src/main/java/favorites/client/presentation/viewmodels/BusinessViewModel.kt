package favorites.client.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import favorites.client.common.Constants
//import favorites.data.repository.ApiProvider
//import favorites.data.repository.BusinessRepository
//import favorites.presentation.screens.search.paging.BusinessSource
import favorites.client.presentation.screens.search.paging.Paginate
//import favorites.presentation.screens.search.paging.SearchOperation
//import favorites.presentation.screens.search.paging.SearchState
import kotlinx.coroutines.launch

class BusinessViewModel : ViewModel() {
//    private val businessRepository: BusinessRepository =
//        BusinessRepository(ApiProvider.businessApi())
//
//    private var _queryText = mutableStateOf("")
//    val queryText: State<String> = _queryText
//    fun setQueryText(query: String) {
//        _queryText.value = query
//    }
//
//
//    private var _locationText = mutableStateOf("")
//    val locationText: State<String> = _locationText
//    fun setLocationText(location: String) {
//        _locationText.value = location
//    }
//
//
//    private var _business = mutableStateOf(Constants.fakeBusiness)
//
//    val business: State<Business> = _business
//
//    fun setBusiness(business: Business) {
//        _business.value = business
//    }
//
//
//    private var _searchState = mutableStateOf(SearchState())
//    val searchState: State<SearchState> = _searchState
//
//
//    fun onSearch() {
//        _searchState.value = SearchState(searchOperation = SearchOperation.LOADING)
//        viewModelScope.launch {
//            _searchState.value = SearchState(
//                data = Pager(
//                    config = PagingConfig(pageSize = 10, prefetchDistance = 5),
//                    pagingSourceFactory = {
//                        BusinessSource(
//                            businessRepository = businessRepository,
//                            paginateData = Paginate(
//                                term = _queryText.value,
//                                location = _locationText.value,
//                            )
//                        )
//                    }
//                ).flow.cachedIn(viewModelScope),
//                searchOperation = SearchOperation.DONE
//            )
//        }
//
//    }


}