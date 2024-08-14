package favorites.client.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import favorites.client.presentation.screens.SearchScreen
import favorites.client.presentation.screens.details.DetailsScreen
import favorites.client.presentation.viewmodels.PokemonViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    pokemonViewModel: PokemonViewModel = viewModel()
//    businessViewModel: BusinessViewModel = viewModel()
) {
    NavHost(navController, startDestination = Screen.Search.route) {
        composable(Screen.Search.route) {
            SearchScreen(
                pokemonViewModel = pokemonViewModel,
                navController = navController
            )
        }
//        composable(Screen.Detail.route) {
//            DetailsScreen(businessViewModel = businessViewModel, navController = navController)
//        }
    }
}