package favorites.client.presentation.viewmodels;

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import favorites.client.common.Constants
import favorites.client.data.models.ArtResponse
import favorites.client.data.models.Datum
import favorites.client.data.repository.ApiProvider
import favorites.client.data.repository.ArtRepository
import favorites.client.presentation.screens.search.paging.ArtSource
import favorites.client.presentation.screens.search.paging.Paginate
//import favorites.client.presentation.screens.search.paging.PokemonSource
import favorites.client.presentation.screens.search.paging.SearchOperation
import favorites.client.presentation.screens.search.paging.SearchState
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow



class ArtViewModel: ViewModel() {
    private val artRepository: ArtRepository = ArtRepository(ApiProvider.artApi())

    private var _queryText = mutableStateOf("")
    val queryText: State<String> = _queryText
    fun setQueryText(query: String) {
        _queryText.value = query
    }

    private var _artwork = mutableStateOf(Constants.fakeArtwork)
    val artwork: State<Datum> = _artwork

    fun setArtwork(artwork: Datum) {
        _artwork.value = artwork
    }



    private var _searchState = mutableStateOf(SearchState())
    val searchState: State<SearchState> = _searchState


    fun onSearch() {
        _searchState.value = SearchState(searchOperation = SearchOperation.LOADING)
        viewModelScope.launch {
            _searchState.value = SearchState(
                    data = Pager(
                            config = PagingConfig(pageSize = 10, prefetchDistance = 5),
                            pagingSourceFactory = {
                                ArtSource(
                                    artRepository = artRepository,
                                    paginateData =  Paginate(
                                        query=_queryText.value
                                    )
                                )
                            }
                    ).flow.cachedIn(viewModelScope),
                    searchOperation = SearchOperation.DONE
            )
        }
    }
}














