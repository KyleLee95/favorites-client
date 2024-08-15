package favorites.client.presentation.screens.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import favorites.client.auth.AmplifyService
import favorites.client.common.Constants
import favorites.client.observers.EventObserver
import favorites.client.presentation.viewmodels.FavoritesViewModel
import favorites.client.presentation.components.CustomBottomNavigationBar
import favorites.client.presentation.components.CustomTopBar

@Composable
fun FavoritesScreen(navController: NavController, amplifyService: AmplifyService, favoritesViewModel: FavoritesViewModel, eventObserver: EventObserver) {
    Scaffold(
        modifier = Constants.modifier,
        bottomBar = { CustomBottomNavigationBar(navController, eventObserver) },
        topBar = {
            CustomTopBar(titleText = "Favorites",navController=navController, amplifyService=amplifyService, eventObserver=eventObserver)

        }
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
                .background(color = Color(0x37000000))
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Favorites View",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
        }
    }
}
