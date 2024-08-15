package favorites.client.presentation.screens.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import favorites.client.common.Constants
import favorites.client.observers.EventObserver
import favorites.client.presentation.viewmodels.FavoritesViewModel
import favorites.client.presentation.components.CustomBottomNavigationBar
import favorites.client.presentation.components.CustomTopBar
import favorites.client.presentation.components.CustomOutlinedTextField
import favorites.client.presentation.screens.search.paging.FavoritesList
import favorites.client.presentation.screens.search.paging.SearchOperation
import favorites.client.presentation.viewmodels.AuthViewModel

@Composable
fun FavoritesScreen(navController: NavController, authViewModel: AuthViewModel, favoritesViewModel: FavoritesViewModel, eventObserver: EventObserver) {

    val state = favoritesViewModel.searchState.value
    val queryText = favoritesViewModel.queryText.value

    Scaffold(
        modifier = Constants.modifier,
        bottomBar = { CustomBottomNavigationBar(navController, eventObserver) },
        topBar = {
            CustomTopBar(
                titleText = "Favorites",
                navController = navController,
                authViewModel = authViewModel,
                eventObserver = eventObserver
            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues = paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            CustomOutlinedTextField(
                title = "Search Favorited Artworks",
                placeHolder = "e.g. Van Gogh",
                textState = queryText,
                onTextChange = favoritesViewModel::setQueryText,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search,
                onSearchDone = favoritesViewModel::onSearch,
                logEvent = { searchTerm -> eventObserver.logUserEvent("search=$searchTerm") }
            )



            Spacer(modifier = Modifier.height(10.dp))
            when (state.searchOperation) {
                SearchOperation.LOADING -> {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(12.dp)
                                .align(Alignment.Center)
                        )
                    }
                }

                SearchOperation.DONE -> {
                    FavoritesList(
                        favoritesViewModel = favoritesViewModel,
                        navController = navController,
                        eventObserver = eventObserver
                    )
                }
                else -> {
                    Box {}
                }

            }
        }
    }
}

