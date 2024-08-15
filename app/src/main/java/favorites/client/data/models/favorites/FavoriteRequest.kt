package favorites.client.data.models.favorites


data class FavoriteRequest(
    val userSessionEmail: String,
    val id: String, // Assuming artworkId is used to identify the artwork
    val favorite: Favorite// Assuming Datum contains the artwork details
)
