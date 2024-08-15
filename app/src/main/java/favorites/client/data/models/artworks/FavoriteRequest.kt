package favorites.client.data.models.artworks


data class FavoriteRequest(
    val userSessionEmail: String,
    val artwork: Datum // Assuming Datum contains the artwork details
)
