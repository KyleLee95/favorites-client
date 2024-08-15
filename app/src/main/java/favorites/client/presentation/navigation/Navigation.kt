package favorites.client.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleObserver
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import favorites.client.auth.AmplifyService
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
import favorites.client.presentation.viewmodels.FavoritesViewModel
import favorites.client.presentation.viewmodels.SamMailerViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    favoritesViewModel: FavoritesViewModel,
    artViewModel: ArtViewModel,
    samMailerViewModel: SamMailerViewModel,
    eventObserver: EventObserver,
    amplifyService: AmplifyService,
) {

    //set start screen conditionally
    val startDestination = if (Constants.authenticate) {
        Screen.Login.route
    } else {
        Screen.Search.route
    }

    NavHost(navController, startDestination = startDestination) {

        composable(Screen.Login.route) {
            LoginScreen(viewModel=favoritesViewModel, navController = navController, amplifyService = amplifyService, eventObserver=eventObserver)
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
                amplifyService=amplifyService,
                favoritesViewModel = favoritesViewModel,
                eventObserver= eventObserver
            )
        }

        composable(Screen.Contact.route) {
            ContactScreen(
                navController = navController,
                amplifyService=amplifyService,
                eventObserver = eventObserver,
                favoritesViewModel = favoritesViewModel,
                samMailerViewModel = samMailerViewModel
                )
        }


        composable(Screen.SignUp.route){
            SignUpScreen(
                viewModel = favoritesViewModel,
                navController = navController ,
                amplifyService = amplifyService,
                eventObserver = eventObserver
                )
        }

        composable(Screen.Verify.route) {
            VerifyScreen(
                viewModel = favoritesViewModel,
                navController = navController,
                amplifyService=amplifyService,
                eventObserver = eventObserver
                )
        }




    }
}