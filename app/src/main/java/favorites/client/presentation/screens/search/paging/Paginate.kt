package favorites.client.presentation.screens.search.paging


data class Paginate(
    val query: String = "",
    val page: Int = 0,
    val limit: Int = 20
)
