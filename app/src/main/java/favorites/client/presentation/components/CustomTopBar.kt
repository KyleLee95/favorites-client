package favorites.client.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import favorites.R
import favorites.client.auth.AmplifyService
import favorites.client.common.Constants
import favorites.client.observers.EventObserver
import favorites.client.presentation.navigation.Screen
import favorites.client.presentation.screens.auth.navigateAndPop
import favorites.client.presentation.viewmodels.AuthViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(titleText: String,  navController: NavController, authViewModel: AuthViewModel,
                 eventObserver: EventObserver) {
    val context = LocalContext.current

    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Transparent
        ),
        title = {
            Text(
                text = titleText,
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )

        },
        actions = {
            if (Constants.authenticate) IconButton(
                onClick = {
                    authViewModel.logOut()
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_logout),
                    contentDescription = "log-out"
                )
            }
        }
    )
}
