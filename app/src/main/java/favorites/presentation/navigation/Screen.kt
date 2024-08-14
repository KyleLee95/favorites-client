package favorites.presentation.navigation


import favorites.R

sealed class Screen(var route: String, var icon: Int, var title: String) {
    object Search : Screen("search", R.drawable.ic_search, "Search")
    object Detail : Screen("detail", R.drawable.ic_book, "Detail")
}
