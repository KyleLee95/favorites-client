package favorites.client.presentation.viewmodels;

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import favorites.client.common.Constants
import favorites.client.data.models.artworks.Datum
import favorites.client.data.models.artworks.FavoriteRequest
import favorites.client.data.repository.ApiProvider
import favorites.client.data.repository.ArtRepository
import favorites.client.data.repository.FavoritesServiceApi
import favorites.client.presentation.screens.search.paging.ArtSource
import favorites.client.presentation.screens.search.paging.Paginate
//import favorites.client.presentation.screens.search.paging.PokemonSource
import favorites.client.presentation.screens.search.paging.SearchOperation
import favorites.client.presentation.screens.search.paging.SearchState
import kotlinx.coroutines.launch


class ArtViewModel: ViewModel() {
    private val artRepository: ArtRepository = ArtRepository(ApiProvider.artApi())
    private val favoritesServiceApi: FavoritesServiceApi = ApiProvider.favoritesApi()
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

    private var currentPage = 1


    fun onSearch() {
        currentPage = 1
        _searchState.value = SearchState(searchOperation = SearchOperation.LOADING)
        viewModelScope.launch {
            _searchState.value = SearchState(
                    data = Pager(
                            config = PagingConfig(pageSize = 10, prefetchDistance = 5),
                            pagingSourceFactory = {
                                ArtSource(
                                    artRepository = artRepository,
                                    paginateData =  Paginate(
                                        query=_queryText.value,
                                        page=currentPage
                                    )
                                )
                            }
                    ).flow.cachedIn(viewModelScope),
                    searchOperation = SearchOperation.DONE
            )
        }
    }

    fun addArtworkToFavorites(userSessionEmail: String) {
        if (userSessionEmail.isBlank()) {
            Log.e("ArtViewModel", "User session email is missing")
            return
        }

        val artwork = _artwork.value
        if (artwork.id == 0 || artwork.title.isNullOrBlank()) {
            Log.e("ArtViewModel", "Artwork data is incomplete")
            return
        }

        viewModelScope.launch {
            val favoriteRequest = FavoriteRequest(
                userSessionEmail = userSessionEmail,
                artwork = artwork
            )

            try {
                val response = favoritesServiceApi.addFavorite(favoriteRequest)
                if (response.isSuccessful) {
                    Log.d("ArtViewModel", "Artwork added to favorites successfully")
                } else {
                    Log.e("ArtViewModel", "Failed to add artwork to favorites: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("ArtViewModel", "An error occurred: ${e.localizedMessage}", e)
            }
        }
    }

}














