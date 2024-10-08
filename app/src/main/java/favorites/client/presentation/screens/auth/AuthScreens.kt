package favorites.client.presentation.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import favorites.client.presentation.viewmodels.AuthState
import favorites.client.presentation.viewmodels.AuthViewModel
import favorites.client.presentation.viewmodels.FavoritesViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


@Composable
fun SignUpScreen(viewModel: AuthViewModel, navController: NavController, eventObserver: EventObserver) {
    val authState by viewModel.authState


    LaunchedEffect(authState) {
        if (authState is AuthState.Verify) {
            navigateAndPop(navController, Screen.Verify.route, eventObserver)
        } else if (authState is AuthState.Error) {
            // Handle error by showing an error message (e.g., snack bar)
            viewModel.setErrorMessage((authState as AuthState.Error).message)
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        if (authState is AuthState.Error) {
            Text(
                text = (authState as AuthState.Error).message,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(7.dp)
            )
        }


        TextField(
            value = viewModel.username.value,
            onValueChange = { viewModel.setUsername(it) },
            placeholder = { Text(text = "Username") }
        )

        TextField(
            value = viewModel.email.value,
            onValueChange = { viewModel.setEmail(it) },
            placeholder = { Text(text = "Email") }
        )

        TextField(
            value = viewModel.password.value,
            onValueChange = { viewModel.setPassword(it) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = { Text(text = "Password") }
        )


        if (authState is AuthState.Loading) {
            CircularProgressIndicator()
            Button(onClick = { viewModel.signUp() }, enabled = false) {
                Text(text = "Sign Up")
            }
        } else {
            Button(onClick = { viewModel.signUp() }) {
                Text(text = "Sign Up")
            }
        }

        TextButton(onClick = {
            MainScope().launch {
                navigateAndPop(navController, Screen.Login.route, eventObserver = eventObserver)
            }
        }) {
            Text(text = "Already have an account? Login.")
        }
    }
}




@Composable
fun LoginScreen(viewModel: AuthViewModel, navController: NavController, eventObserver: EventObserver) {
    val authState by viewModel.authState

    LaunchedEffect(authState) {
        if (authState is AuthState.Success) {
            navigateAndPop(navController, Screen.Search.route, eventObserver)
        } else if (authState is AuthState.Error) {
            // Handle error by showing an error message (e.g., snack bar)
             viewModel.setErrorMessage((authState as AuthState.Error).message)
        }
    }

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            if(authState is AuthState.Error){
                Text(
                    text = (authState as AuthState.Error).message,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(8.dp)
                )
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

            if(authState is AuthState.Loading){
                CircularProgressIndicator()

                Button(onClick = {
                    viewModel.login()
                },
                    enabled = false
                ) {
                    Text(text = "Login")
                }

            }else {
                Button(onClick = {
                    viewModel.login()
                }
                ) {
                    Text(text = "Login")
                }
            }

                TextButton(onClick = {
                    viewModel.setAuthState(AuthState.Idle)
            MainScope().launch {
                navigateAndPop(navController, Screen.SignUp.route, eventObserver=eventObserver)} }

                ) {
            Text(text = "Don't have an account? Sign up.")
        }
    }
}






@Composable
fun VerifyScreen(viewModel: AuthViewModel, navController: NavController, eventObserver: EventObserver) {
    val authState by viewModel.authState
    // Handle navigation when the auth state is successful
    LaunchedEffect(authState) {
        if (authState is AuthState.Success) {
            navigateAndPop(navController, Screen.Login.route, eventObserver)
            eventObserver.logUserEvent(event = "verify-${viewModel.username.value}")
        } else if (authState is AuthState.Error) {
            // Handle error by showing an error message (e.g., snack bar)
             viewModel.setErrorMessage((authState as AuthState.Error).message)
        }
    }


    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        // Loading indicator overlay
        if (authState is AuthState.Error) {
            Text(
                text = (authState as AuthState.Error).message,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(8.dp)
            )
        }

        TextField(
            value = viewModel.code.value,
            onValueChange = { viewModel.setCode(it) },
            placeholder = { Text(text = "Verification Code") }
        )
        if(authState is AuthState.Loading){
            CircularProgressIndicator()
            Button(onClick = { viewModel.verifyCode() }, enabled = false){
                Text(text = "Verify")
            }
        }else{
            Button(onClick = { viewModel.verifyCode() }, enabled = viewModel.code.value.isNotEmpty()){
                Text(text = "Verify")
            }
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
