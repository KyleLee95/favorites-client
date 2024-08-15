package favorites.client.presentation.navigation


import favorites.R

sealed class Screen(var route: String, var icon: Int, var title: String) {
    object Search : Screen("search", R.drawable.ic_search, "Search")
    object Detail : Screen("detail", R.drawable.ic_book, "Detail")
    object Login : Screen("login", 0, "Login")
    object SignUp : Screen("signup", 0, "Signup")
    object Verify : Screen("verify", 0, "Verify")
    object Favorites : Screen("favorites", R.drawable.ic_favorite, "Favorites")
    object FavoritesDetail : Screen("favorites-detail", R.drawable.ic_favorite, "Favorite")
    object Contact: Screen("contact", R.drawable.ic_book, "Contact")


}
