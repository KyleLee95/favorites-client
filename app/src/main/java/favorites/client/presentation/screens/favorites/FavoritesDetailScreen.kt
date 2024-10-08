package favorites.client.presentation.screens.favorites


import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.skydoves.landscapist.glide.GlideImage
//import com.skydoves.landscapist.glide.GlideImage
import favorites.client.common.Constants
import favorites.client.common.Constants.modifier
import favorites.client.observers.EventObserver
import favorites.client.presentation.screens.details.DetailsScreen
import favorites.client.presentation.viewmodels.ArtViewModel
import favorites.client.presentation.viewmodels.AuthViewModel
import favorites.client.presentation.viewmodels.FavoritesViewModel
import favorites.ui.theme.SuccessGreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesDetailsScreen(
    favoritesViewModel: FavoritesViewModel,
    authViewModel: AuthViewModel,
    navController: NavController,
    eventObserver: EventObserver
) {

    val favorite = favoritesViewModel.favorite.value
    val activity = (LocalContext.current as? Activity)


    Scaffold(
        modifier = Constants.modifier,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                title = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Icon(imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Arrow Back",
                            modifier = Modifier
                                .clickable {
                                    navController.popBackStack()
                                }
                                .align(Alignment.CenterVertically)
                                .padding(20.dp, 0.dp, 0.dp, 0.dp))

                        Text(
                            text = "Details",
                            modifier = Modifier
                                .align(Alignment.CenterVertically),
                            style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                            textAlign = TextAlign.Center,
                            fontSize = 25.sp
                        )

                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                        ) {

                            Spacer(modifier = Modifier.width(20.dp))
                            Spacer(modifier = Modifier.width(20.dp))
                        }

                    }

                })
        }
    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .padding(paddingValues = paddingValues)
                .fillMaxWidth()
                .verticalScroll(state = rememberScrollState(0))
                .padding(20.dp, 0.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                HorizontalDivider()
                Spacer(Modifier.height(20.dp))
                //we can use either coil or glide for images. If you need animations, use coil
                GlideImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(300.dp),
                    imageModel = "https://www.artic.edu/iiif/2/".plus(favorite.artwork.imageId)
                        .plus("/full/843,/0/default.png"),
                    contentScale = ContentScale.Fit
                )
                with(favorite.artwork) {
                    title?.let {
                        Text(
                            text = it,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Start),
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            textAlign = TextAlign.Start,
                            fontSize = 22.sp
                        )
                    }


                    artistDisplay?.let {
                        Text(
                            text = it,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Start),
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            textAlign = TextAlign.Start,
                            fontSize = 22.sp
                        )
                    }


                    placeOfOrigin?.let {
                        Text(
                            text = it,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Start),
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            textAlign = TextAlign.Start,
                            fontSize = 22.sp
                        )
                    }

                    mediumDisplay?.let {
                        Text(
                            text = it,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Start),
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            textAlign = TextAlign.Start,
                            fontSize = 22.sp
                        )
                    }

                    dimensions?.let {
                        Text(
                            text = it,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Start),
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            textAlign = TextAlign.Start,
                            fontSize = 22.sp
                        )
                    }

                    styleTitle?.let {
                        Text(
                            text = it,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Start),
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            textAlign = TextAlign.Start,
                            fontSize = 22.sp
                        )
                    }

                    exhibitionHistory?.let{
                        Text(
                            text = it.toString(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Start),
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            textAlign = TextAlign.Start,
                            fontSize = 22.sp
                        )
                    }
                }
                HorizontalDivider(modifier = Modifier.padding(10.dp))
                Button(
                    modifier =
                    Modifier
                        .padding(10.dp, 0.dp)
                        .fillMaxWidth(1f),

                    onClick = {
                        eventObserver.logUserEvent(event = "remove-from-favorites-${favorite.id}")
                        favoritesViewModel.deleteFavorite(favoriteId = favorite.id)
                        Toast.makeText(
                            activity,
                            "Removed Favorites!",
                            Toast.LENGTH_LONG
                        ).show()
                    },
                    colors =
                    ButtonDefaults.buttonColors(containerColor = SuccessGreen)
                ) {
                    Text(text = "Remove from Favorites")
                }

            }
        }
    }
}




@Composable
@Preview
fun DetailsPreview() {
    val artViewModel = ArtViewModel()
    val authViewModel = AuthViewModel()
    DetailsScreen(artViewModel=artViewModel, authViewModel=authViewModel, navController = rememberNavController(), eventObserver = EventObserver(authViewModel=authViewModel))
}
