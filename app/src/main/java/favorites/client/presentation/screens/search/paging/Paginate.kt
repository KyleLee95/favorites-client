package favorites.client.presentation.screens.search.paging


data class Paginate(
    val query: String = "",
    val page: Int = 0,
    val limit: Int = 20,
    val fields: String = "id,title,image_id,alt_titles,artist_display,dimensions,dimensions_detail,medium_display,place_of_origin,gallery_title,style_title,classication_title,exhibition_history,api_model,api_link,config"
)

data class PaginateFavorites(
    val page: Int =0,
    val limit: Int = 20,
    val user_session_email: String = "",
    val query: String = "",
)