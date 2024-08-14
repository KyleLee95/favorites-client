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
import favorites.presentation.navigation.Screen
import favorites.presentation.viewmodels.BusinessViewModel


@Composable
fun BusinessList(
    businessViewModel: BusinessViewModel,
    navController: NavController
) {
    val lazyPagingItems = businessViewModel.searchState.value.data?.collectAsLazyPagingItems()
    LazyColumn {
        items(
            count = lazyPagingItems!!.itemCount,
            key = lazyPagingItems.itemKey(),
            contentType = lazyPagingItems.itemContentType()
        ) { index ->
            val boolItem = lazyPagingItems[index]!!
            BusinessRow(business = boolItem) {
                businessViewModel.setBusiness(boolItem)
                navController.navigate(
                    route = Screen.Detail.route
                )
            }
        }
        lazyPagingItems.apply {
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

@Composable
fun Spinner() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .padding(12.dp)
                .align(
                    Alignment.Center
                )
        )
    }
}

