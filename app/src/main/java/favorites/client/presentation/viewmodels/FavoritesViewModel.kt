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
import favorites.client.data.models.favorites.FavoriteRequest
import favorites.client.data.repository.ApiProvider
import favorites.client.presentation.screens.search.paging.FavoritesSource
import favorites.client.presentation.screens.search.paging.SearchOperation
import favorites.client.presentation.screens.search.paging.FavoritesSearchState
import favorites.client.presentation.screens.search.paging.PaginateFavorites
import kotlinx.coroutines.launch


class FavoritesViewModel(private val authViewModel: AuthViewModel): ViewModel() {
    private val favoritesRepository: FavoritesRepository = FavoritesRepository(ApiProvider.favoritesApi())

    // Loading and Error State
    private var _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading
    fun setLoading(loading:Boolean){
        _isLoading.value = loading
    }

    private var _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage
    fun setErrorMessage(message:String?){
        _errorMessage.value = message

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
                                favoritesRepository = favoritesRepository,
                                paginateData = PaginateFavorites(
                                    page = currentPage,
                                    user_session_email = authViewModel.email.value,
                                    query = _queryText.value
                                    )
                            )
                        }
                    ).flow.cachedIn(viewModelScope),
                    searchOperation = SearchOperation.DONE
                )
        }
    }


    // Function to delete a favorite
    fun deleteFavorite(favoriteId: String) {
        setLoading(true)
        viewModelScope.launch {
            try {
                val response = favoritesRepository.deleteFavorite(favoriteId)
                if (response.isSuccessful) {
                    // Handle successful deletion (e.g., show a message)
                } else {
                    setErrorMessage("Failed to delete favorite: ${response.message()}")
                }
            } catch (e: Exception) {
                setErrorMessage("An error occurred: ${e.localizedMessage}")
            } finally {
                setLoading(false)
            }
        }
    }
}














