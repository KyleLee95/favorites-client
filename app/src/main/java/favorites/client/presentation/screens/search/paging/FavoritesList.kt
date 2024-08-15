package favorites.client.presentation.screens.search.paging

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import favorites.client.observers.EventObserver
import favorites.client.presentation.navigation.Screen
import favorites.client.presentation.viewmodels.FavoritesViewModel
import favorites.client.presentation.components.Spinner
@Composable
fun FavoritesList(favoritesViewModel: FavoritesViewModel, navController: NavController, eventObserver: EventObserver) {

    //this is what consumes the flow
    val lazyPagingItems = favoritesViewModel.searchState.value.data?.collectAsLazyPagingItems()

    LazyColumn {
        items(
            count = lazyPagingItems!!.itemCount,
            key = lazyPagingItems.itemKey(),
            contentType = lazyPagingItems.itemContentType()
        ) { index ->
            val boolFavorite= lazyPagingItems[index]!!
            FavoritesRow(favorite= boolFavorite){
                eventObserver.logUserEvent("search-detail-${boolFavorite.id}")
                favoritesViewModel.setFavorite(boolFavorite)
                navController.navigate(route=Screen.Detail.route)
            }
        }

        lazyPagingItems.apply {
            //fallthrough is not supported
            when {
                loadState.refresh is LoadState.Loading -> {
                    item {
                        Spinner()
                    }
                }
                loadState.append is LoadState.Loading -> {
                    item {
                        Spinner()
                    }
                }
                loadState.prepend is LoadState.Loading -> {
                    item {
                        Spinner()
                    }
                }
            }
        }
    }
}

