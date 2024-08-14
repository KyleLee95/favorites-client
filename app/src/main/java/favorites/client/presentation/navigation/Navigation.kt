package favorites.client.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import favorites.client.presentation.screens.search.SearchScreen
import favorites.client.presentation.screens.details.DetailsScreen
import favorites.client.presentation.viewmodels.ArtViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    artViewModel: ArtViewModel
) {
    NavHost(navController, startDestination = Screen.Search.route) {
        composable(Screen.Search.route) {
            SearchScreen(
                artViewModel,
                navController = navController
            )
        }
        composable(Screen.Detail.route) {
            DetailsScreen(artViewModel, navController = navController)
        }
    }
}