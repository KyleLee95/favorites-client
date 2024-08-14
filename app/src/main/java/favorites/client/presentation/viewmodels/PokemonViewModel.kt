package favorites.client.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import favorites.client.common.Constants
import favorites.client.data.models.pokemondetails.PokemonDetailsResponse
import favorites.client.data.models.pokemonlist.Result
import favorites.client.data.repository.ApiProvider
import favorites.client.data.repository.PokemonRepository
import favorites.client.presentation.screens.search.paging.Paginate
import favorites.client.presentation.screens.search.paging.PokemonSource
import favorites.client.presentation.screens.search.paging.SearchOperation
import favorites.client.presentation.screens.search.paging.SearchState
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow



class PokemonViewModel : ViewModel() {
    private val pokemonRepository: PokemonRepository = PokemonRepository(ApiProvider.pokemonApi())

    private var _queryText = mutableStateOf("")
    val queryText: State<String> = _queryText
    fun setQueryText(query: String) {
        _queryText.value = query
    }


    private var _pokemonList = mutableStateOf<Flow<PagingData<Result>>?>(null)
    val pokemonList: Flow<PagingData<Result>>?
        get() = _pokemonList.value

    private var _pokemonDetails = mutableStateOf(Constants.fakePokemonDetailsResponse)
    val pokemonDetails = _pokemonDetails

    fun setPokemon(pokemon: PokemonDetailsResponse) {
//        _pokemonDetails.value = pokemon
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
                        PokemonSource(
                            pokemonRepository = pokemonRepository,
                            paginateData = Paginate(
                                term = _queryText.value,
                            )
                        )
                    }
                ).flow.cachedIn(viewModelScope),
                searchOperation = SearchOperation.DONE
            )
        }
    }
}














