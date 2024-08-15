package favorites.client.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import favorites.client.common.Constants
import favorites.client.observers.EventObserver
import favorites.client.presentation.screens.auth.LoginScreen
import favorites.client.presentation.screens.auth.SignUpScreen
import favorites.client.presentation.screens.auth.VerifyScreen
import favorites.client.presentation.screens.contact.ContactScreen
import favorites.client.presentation.screens.search.SearchScreen
import favorites.client.presentation.screens.details.DetailsScreen
import favorites.client.presentation.screens.favorites.FavoritesScreen
import favorites.client.presentation.viewmodels.ArtViewModel
import favorites.client.presentation.viewmodels.AuthViewModel
import favorites.client.presentation.viewmodels.FavoritesViewModel
import favorites.client.presentation.viewmodels.SamMailerViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    favoritesViewModel: FavoritesViewModel,
    artViewModel: ArtViewModel,
    samMailerViewModel: SamMailerViewModel,
    authViewModel: AuthViewModel,
    eventObserver: EventObserver,
) {

    //set start screen conditionally
    val startDestination = if (Constants.authenticate) {
        Screen.Login.route
    } else {
        Screen.Search.route
    }

    NavHost(navController, startDestination = startDestination) {

        composable(Screen.Login.route) {
            LoginScreen(viewModel= authViewModel, navController = navController, eventObserver=eventObserver)
        }

        composable(Screen.Search.route) {
            SearchScreen(
                artViewModel = artViewModel,
                navController = navController,
                eventObserver = eventObserver
            )
        }

        composable(Screen.Detail.route){
            DetailsScreen(
                artViewModel = artViewModel,
                navController = navController,
                eventObserver = eventObserver
            )
        }

        composable(Screen.Favorites.route) {
            FavoritesScreen(
                navController = navController,
                favoritesViewModel = favoritesViewModel,
                authViewModel = authViewModel,
                eventObserver= eventObserver
            )
        }

        composable(Screen.Contact.route) {
            ContactScreen(
                navController = navController,
                eventObserver = eventObserver,
                authViewModel = authViewModel,
                samMailerViewModel = samMailerViewModel
                )
        }


        composable(Screen.SignUp.route){
            SignUpScreen(
                viewModel = authViewModel,
                navController = navController ,
                eventObserver = eventObserver
                )
        }

        composable(Screen.Verify.route) {
            VerifyScreen(
                viewModel = authViewModel,
                navController = navController,
                eventObserver = eventObserver
                )
        }




    }
}