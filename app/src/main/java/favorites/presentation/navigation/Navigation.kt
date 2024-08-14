package favorites.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import favorites.presentation.screens.SearchScreen
import favorites.presentation.screens.details.DetailsScreen
import favorites.presentation.viewmodels.BusinessViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    businessViewModel: BusinessViewModel = viewModel()
) {
    NavHost(navController, startDestination = Screen.Search.route) {
        composable(Screen.Search.route) {
            SearchScreen(
                businessViewModel = businessViewModel,
                navController = navController
            )
        }
        composable(Screen.Detail.route) {
            DetailsScreen(businessViewModel = businessViewModel, navController = navController)
        }
    }
}