package favorites.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun YelpMap(modifier: Modifier = Modifier, yelpLocation: LatLng = LatLng(37.7749, -122.4194)) {
    // Define the Yelp location's latitude and longitude


    // Create a camera position state
    val cameraPositionState = rememberCameraPositionState {
        position =
            com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(yelpLocation, 15f)
    }

    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = rememberMarkerState(position = yelpLocation), title = "Yelp Location",
            snippet = "This is the location of the Yelp place."
        )
    }
}