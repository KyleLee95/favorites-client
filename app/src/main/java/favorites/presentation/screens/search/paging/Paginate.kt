package favorites.presentation.screens.search.paging

data class Paginate(
    val term: String = "",
    val location: String = "",
    val offset: Int = 0,
    val limit: Int = 20
)
