package favorites.client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import favorites.client.auth.AmplifyService
import favorites.client.presentation.navigation.Navigation
import favorites.client.presentation.viewmodels.ArtViewModel
import favorites.client.presentation.viewmodels.FavoritesViewModel
import favorites.ui.theme.ClientTheme


//@OptIn(ExperimentalAnimationApi::class)
//class MainActivity : ComponentActivity() {
//    private val amplifyService: AmplifyService = AmplifyService()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        amplifyService.configureAmplify(this)
//        setContent {
//            FavoriteBooksTheme {
//                val navController = rememberAnimatedNavController()
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Navigation(navController = navController, amplifyService = amplifyService)
//                }
//            }
//        }
//    }
//}

@OptIn(ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity() {
    private val amplifyService: AmplifyService = AmplifyService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amplifyService.configureAmplify(this)
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
                        amplifyService = amplifyService,
                        navController = navController
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
