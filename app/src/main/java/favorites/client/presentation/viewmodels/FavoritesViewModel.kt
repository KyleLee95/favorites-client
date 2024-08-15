package favorites.client.presentation.viewmodels

import favorites.client.data.repository.FavoritesRepository


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import favorites.client.common.Constants
import favorites.client.data.models.favorites.Favorite
import favorites.client.data.repository.ApiProvider
import favorites.client.presentation.screens.search.paging.FavoritesSource
import favorites.client.presentation.screens.search.paging.SearchOperation
import favorites.client.presentation.screens.search.paging.FavoritesSearchState
import favorites.client.presentation.screens.search.paging.PaginateFavorites
import kotlinx.coroutines.launch


class FavoritesViewModel: ViewModel() {
    private val favoritesRepository: FavoritesRepository = FavoritesRepository(ApiProvider.favoritesApi())

    // AUTH //

    private var _username = mutableStateOf("")
    val username: State<String> = _username

    private var _email = mutableStateOf("")
    val email: State<String> = _email

    private var _password = mutableStateOf("")
    val password: State<String> = _password

    private var _code = mutableStateOf("")
    val code: State<String> = _code

    fun setUsername(text: String){
        _username.value = text
    }
    fun setEmail(text: String){
        _email.value = text
    }

    fun setPassword(text: String){
        _password.value = text
    }

    fun setCode(text: String){
        _code.value = text
    }

    // FAVORITES //


    private var _queryText = mutableStateOf("")
    val queryText: State<String> = _queryText
    fun setQueryText(query: String) {
        _queryText.value = query
    }

    private var _favorite = mutableStateOf(Constants.fakeFavorite)
    val favorite: State<Favorite> = _favorite

    fun setFavorite(favorite: Favorite) {
        _favorite.value= favorite
    }

    private var _searchState = mutableStateOf(FavoritesSearchState())
    val searchState: State<FavoritesSearchState> = _searchState

    private var currentPage = 1

    fun onSearch() {
        currentPage = 1
        _searchState.value = FavoritesSearchState(searchOperation = SearchOperation.LOADING)
        viewModelScope.launch {
            _searchState.value = FavoritesSearchState(
                data = Pager(
                    config = PagingConfig(pageSize = 10, prefetchDistance = 5),
                    pagingSourceFactory = {
                        FavoritesSource(
                            favoritesRepository= favoritesRepository,
                            paginateData =  PaginateFavorites(
                                page = currentPage
                            )
                        )
                    }
                ).flow.cachedIn(viewModelScope),
                searchOperation = SearchOperation.DONE
            )
        }
    }
}














