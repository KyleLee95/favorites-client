package favorites.client.presentation.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import favorites.client.auth.AmplifyService
import favorites.client.observers.EventObserver
import favorites.client.presentation.navigation.Screen
import favorites.client.presentation.viewmodels.FavoritesViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


@Composable
fun SignUpScreen(viewModel: FavoritesViewModel, navController: NavController, amplifyService: AmplifyService, eventObserver: EventObserver) {


    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = viewModel.username.value,
            onValueChange = { viewModel.setUsername(it) },
            placeholder = { Text(text = "Username") }
        )

        TextField(
            value = viewModel.email.value,
            onValueChange = { viewModel.setEmail(it)},
            placeholder = { Text(text = "Email") }
        )

        TextField(
            value = viewModel.password.value,
            onValueChange = { viewModel.setPassword(it) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = { Text(text = "Password") }
        )


        Button(onClick = {
            amplifyService.signUp(viewModel.username.value, viewModel.email.value, viewModel.password.value){
                MainScope().launch {
                    navigateAndPop(navController, Screen.Verify.route, eventObserver =eventObserver )
                }

            }


        }) {
            Text(text = "Sign Up")
        }

        TextButton(onClick = {
            MainScope().launch {
                navigateAndPop(navController, Screen.Login.route, eventObserver=eventObserver)}}) {
            Text(text = "Already have an account? Login.")
        }
    }
}
@Composable
fun LoginScreen(viewModel: FavoritesViewModel, navController: NavController, amplifyService: AmplifyService, eventObserver: EventObserver) {
    val isLoading by viewModel.isLoading
    val errorMessage by viewModel.errorMessage
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        if(isLoading){
            CircularProgressIndicator()
        }
        TextField(
            value = viewModel.username.value,
            onValueChange = { viewModel.setUsername(it) },
            placeholder = { Text(text = "Username") }
        )

        TextField(
            value = viewModel.password.value,
            onValueChange = { viewModel.setPassword(it)  },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = { Text(text = "Password") }
        )

        if(errorMessage != null){
            Text(
                text = errorMessage ?: "",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(8.dp)
            )
        }

        Button(onClick = {
            amplifyService.login(viewModel.username.value, viewModel.password.value) {
                //this method will log the user's email address to Logcat. Filter for ampy
                amplifyService.fetchEmailAndLog()
                MainScope().launch {
                    navigateAndPop(navController, Screen.Search.route, eventObserver)
                }
            }
        }
            ) {
                Text(text = "Login")
            }

        TextButton(onClick = {
            MainScope().launch {
                navigateAndPop(navController, Screen.SignUp.route, eventObserver=eventObserver)} }

        ) {
            Text(text = "Don't have an account? Sign up.")
        }
    }
}
@Composable
fun VerifyScreen(viewModel: FavoritesViewModel, navController: NavController, amplifyService: AmplifyService, eventObserver: EventObserver) {


    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = viewModel.code.value,
            onValueChange = { viewModel.setCode(it) },
            placeholder = { Text(text = "Verification Code") }
        )

        Button(onClick = {
            viewModel.setLoading(true)
            viewModel.setErrorMessage(null)
            amplifyService.verifyCode(viewModel.username.value, viewModel.code.value){
                MainScope().launch {
                    navigateAndPop(navController, Screen.Login.route, eventObserver)
                }
                eventObserver.logUserEvent(event="verify-${viewModel.username.value}")
            }
        }) {
            Text(text = "Verify")
        }
    }
}

fun navigateAndPop(navController: NavController, routeString:String, eventObserver: EventObserver){
    navController.navigate(routeString) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        navController.graph.startDestinationRoute?.let { route ->
            eventObserver.logUserEvent(event="navigate-$route")
            popUpTo(route) {
                saveState = true
            }
        }
        // Avoid multiple copies of the same destination when
        // re-selecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }
}
