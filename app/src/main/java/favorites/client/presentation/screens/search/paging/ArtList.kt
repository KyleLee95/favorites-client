package favorites.client.presentation.screens.search.paging

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import favorites.client.observers.EventObserver
import favorites.client.presentation.navigation.Screen
import favorites.client.presentation.viewmodels.ArtViewModel
import favorites.client.presentation.components.Spinner
import favorites.client.presentation.viewmodels.AuthViewModel

@Composable
fun ArtList(artViewModel: ArtViewModel, navController: NavController, eventObserver: EventObserver) {

    //this is what consumes the flow
    val lazyPagingItems = artViewModel.searchState.value.data?.collectAsLazyPagingItems()

    LazyColumn {
        items(
            count = lazyPagingItems!!.itemCount,
            key = lazyPagingItems.itemKey(),
            contentType = lazyPagingItems.itemContentType()
        ) { index ->
            val boolArtwork = lazyPagingItems[index]!!
            ArtworkRow(artwork = boolArtwork){
                eventObserver.logUserEvent("search-detail-${boolArtwork.id}")
                artViewModel.setArtwork(boolArtwork)
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

