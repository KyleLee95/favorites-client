package favorites.client.presentation.screens.search.paging

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter
import favorites.client.data.models.Datum
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.compose.ui.graphics.asImageBitmap


fun decodeBase64ToBitmap(base64Str: String): Bitmap? {
    // Remove the header from the base64 string if it exists
    val cleanBase64String = base64Str.substringAfter("base64,")

    // Decode the base64 string into a byte array
    val decodedBytes = Base64.decode(cleanBase64String, Base64.DEFAULT)

    // Convert the byte array into a Bitmap
    return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
}

@Composable
fun ArtworkRow(
    artwork: Datum,
    onItemClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                artwork.title?.let {
                    onItemClick(it)
                }
            }
            .padding(10.dp, 5.dp, 5.dp, 10.dp),
        shape = RoundedCornerShape(corner = CornerSize(4.dp)),
        elevation = CardDefaults.cardElevation(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(horizontalArrangement = Arrangement.Start) {

            Surface(modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp)) {
                // Check if the thumbnail is a base64 string or a URL
                if (artwork.thumbnail.lqip != null) {
                    // Handle base64 encoded images
                    val bitmap = decodeBase64ToBitmap(artwork.thumbnail.lqip)
                    bitmap?.let {
                        Image(
                            bitmap = it.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(60.dp)
                                .height(90.dp),
                            contentScale = ContentScale.FillHeight
                        )
                    }
                } else {
                    // Handle URL images with Coil
                    val image = rememberCoilPainter(
                        request ="https://picsum.photos/id/1026/60/90",
                        fadeIn = true
                    )
                    Image(
                        painter = image,
                        contentDescription = null,
                        modifier = Modifier
                            .width(60.dp)
                            .height(90.dp),
                        contentScale = ContentScale.FillHeight
                    )
                }
            }

            Column {
                Text(
                    text = artwork.title ?: "No Title",
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp
                )
                Text(text = artwork.title ?: "None")
            }
        }
    }
}
