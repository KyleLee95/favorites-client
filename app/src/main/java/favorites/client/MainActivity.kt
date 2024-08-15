package favorites.client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.navigation.compose.rememberNavController
import favorites.client.auth.AmplifyService
import favorites.client.presentation.navigation.Navigation
import favorites.client.presentation.viewmodels.ArtViewModel
import favorites.client.presentation.viewmodels.FavoritesViewModel
import favorites.client.presentation.viewmodels.SamMailerViewModel
import favorites.client.observers.EventObserver
import favorites.ui.theme.ClientTheme


class MainActivity : ComponentActivity() {
    private val amplifyService: AmplifyService = AmplifyService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amplifyService.configureAmplify(this)

        val eventObserver = EventObserver(sessionEmail="kchow1@uchicago.edu")
        ProcessLifecycleOwner.get().lifecycle.addObserver(eventObserver)


        setContent {
            ClientTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                )
                {
                    Navigation(
                        artViewModel = ArtViewModel(),
                        favoritesViewModel = FavoritesViewModel(),
                        samMailerViewModel = SamMailerViewModel(),
                        amplifyService = amplifyService,
                        navController = navController,
                        eventObserver = eventObserver
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClientTheme { Greeting("Android") }
}
