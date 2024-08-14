package favorites.client.presentation.screens.details


import android.app.Activity
import android.content.Intent
import android.net.Uri
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
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.LatLng
import com.skydoves.landscapist.glide.GlideImage
import favorites.client.common.Constants
import favorites.client.presentation.viewmodels.BusinessViewModel
import favorites.client.presentation.viewmodels.PokemonViewModel
import favorites.ui.theme.ErrorRed
import favorites.ui.theme.SuccessGreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    pokemonViewModel: PokemonViewModel,
    navController: NavController
) {

    //observe the book
//    val business = businessViewModel.business.value
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

//                            Icon(imageVector = Icons.Default.Share,
//                                contentDescription = "Share",
//                                modifier = Modifier
//                                    .clickable {
//                                        val sendIntent = Intent(Intent.ACTION_SEND)
//                                        sendIntent.type = "text/plain"
//                                        sendIntent.putExtra(
//                                            Intent.EXTRA_TEXT,
//                                            "Check out this place!: ${business.name}"
//                                        )
//                                        activity?.startActivity(sendIntent)
//                                    }
//                                    .align(Alignment.CenterVertically)
//                                    .padding(10.dp, 0.dp, 0.dp, 0.dp))
                            Spacer(modifier = Modifier.width(20.dp))
//                            Icon(painter = painterResource(id = R.drawable.ic_navigation),
//                                contentDescription = "Map",
//                                modifier = Modifier
//                                    .clickable {
//                                        val streetName = business.location.address1
//                                        val streetType = business.location.address2
//                                        val unit = business.location.address3
//                                        val city = business.location.city
//                                        val state = business.location.state
//                                        val zipcode = business.location.zipCode
//                                        val businessAddress =
//                                            "${streetName} ${streetType} ${unit}, ${city}, ${state}, ${zipcode}"
//                                        val intent = Intent(
//                                            Intent.ACTION_VIEW,
//                                            Uri.parse(
//                                                "google.navigation:q=$businessAddress"
//                                            )
//                                        )
//                                        activity?.startActivity(intent)
//                                    }
//                                    .align(Alignment.CenterVertically)
//                                    .padding(10.dp, 0.dp, 10.dp, 0.dp))
                            Spacer(modifier = Modifier.width(20.dp))
//                            Icon(imageVector = Icons.Default.Phone,
//                                contentDescription = "Phone",
//                                modifier = Modifier
//                                    .clickable {
//                                        //this would be used for dialing if you have a phone number
//                                        val phoneNumber = business.phone
//                                        val intent = Intent(
//                                            Intent.ACTION_DIAL,
//                                            Uri.parse("tel:$phoneNumber")
//                                        )
//                                        activity?.startActivity(intent)
//                                    }
//                                    .align(Alignment.CenterVertically)
//                                    .padding(0.dp, 0.dp, 20.dp, 0.dp))
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
//                GlideImage(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .size(300.dp),
//                    imageModel = business.imageUrl ?: "https://picsum.photos/id/1026/200/300",
//                    contentScale = ContentScale.Fit
//                )
//                with(business) {
//                    name?.let {
//                        Text(
//                            text = it,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .align(Alignment.Start),
//                            style = TextStyle(fontWeight = FontWeight.Bold),
//                            textAlign = TextAlign.Start,
//                            fontSize = 22.sp
//                        )
//                    }
//                    //rating
//                    rating?.let {
//                        Row(
//                            modifier = Modifier.align(Alignment.Start),
//                        ) {
//                            for (i in 1..it.toInt()) {
//                                Icon(
//                                    modifier = Modifier
//                                        .fillMaxHeight()
//                                        .align(Alignment.CenterVertically),
//                                    painter = painterResource(id = R.drawable.star_box),
//                                    contentDescription = "Review Star",
//                                )
//                            }
//                            Text(
//                                text = "(${business.reviewCount} reviews)",
//                                modifier = Modifier
//                                    .fillMaxHeight()
//                                    .align(Alignment.CenterVertically)
//                                    .padding(5.dp, 0.dp),
//                                style = TextStyle(fontWeight = FontWeight.Bold),
//                                textAlign = TextAlign.Start,
//                                fontSize = 22.sp
//                            )
//                        }
//                    }
                    //hours
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Start),
                    ) {

//                        isClosed?.let {
//                            val isOpen = if (it) "Closed" else "Open Now"
//                            val textColor = if (it) ErrorRed else SuccessGreen
//                            Text(
//                                text = isOpen,
//                                modifier = Modifier,
//                                style = TextStyle(
//                                    fontWeight = FontWeight.Bold,
//                                    color = textColor
//                                ),
//                                textAlign = TextAlign.Start,
//                                fontSize = 18.sp
//                            )
//                        }


//                        businessHours?.let {
//                            val businessOpenHours = it[0].open[0]
//                            val opensAt = convertMilitaryTo12HourTime(businessOpenHours.start)
//                            val closesAt = convertMilitaryTo12HourTime(businessOpenHours.end)
//                            Text(
//                                text = "${opensAt} - ${closesAt}",
//                                modifier = Modifier.padding(10.dp, 0.dp),
//                                style = TextStyle(
//                                    fontWeight = FontWeight.Bold,
//                                    color = Color.Gray,
//                                    fontSize = 18.sp
//                                )
//                            )
//                        }
                    }
                }
                HorizontalDivider(modifier = Modifier.padding(10.dp))
                Button(
                    modifier =
                    Modifier
                        .padding(10.dp, 0.dp)
                        .fillMaxWidth(1f),

                    onClick = {
                        Toast.makeText(
                            activity,
                            "Added to Favorites!",
                            Toast.LENGTH_LONG
                        ).show()
                    },
                    colors =
                    ButtonDefaults.buttonColors(containerColor = SuccessGreen)
                ) {
                    Text(text = "Add to Favorites")
                }

//                val yelpLocation =
//                    LatLng(business.coordinates.latitude, business.coordinates.longitude)

//                YelpMap(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(300.dp),
//                    yelpLocation = yelpLocation
//                )
            }
        }
}



@Composable
@Preview
fun DetailsPreview() {
    val pokemonViewModel = PokemonViewModel()
    DetailsScreen(pokemonViewModel=pokemonViewModel, navController = rememberNavController())
}
