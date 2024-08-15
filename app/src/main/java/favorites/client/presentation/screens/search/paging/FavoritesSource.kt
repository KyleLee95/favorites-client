package favorites.client.presentation.screens.search.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import favorites.client.data.models.favorites.Favorite
import favorites.client.data.repository.FavoritesRepository

class FavoritesSource(
    private val favoritesRepository: FavoritesRepository,
    private val paginateData: PaginateFavorites
) : PagingSource<Int, Favorite>() {

    override fun getRefreshKey(state: PagingState<Int, Favorite>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Favorite> {
        return try {
            val currentPage = params.key ?: 1

            val response = favoritesRepository.searchFavorites(page = currentPage, limit = params.loadSize, query=paginateData.query, user_session_email=paginateData.user_session_email )

            if (response.isSuccessful) {
                val body = response.body()

                if (body != null) {

                    val pagination = body.pagination

                    val nextKey = if (pagination.currentPage < pagination.totalPages) {
                        currentPage + 1
                    } else {
                        null
                    }

                    LoadResult.Page(
                        data = body.data,
                        prevKey = if (currentPage == 1) null else currentPage - 1,
                        nextKey = nextKey
                    )
                } else {
                    LoadResult.Error(Exception("Empty response body"))
                }
            } else {
                LoadResult.Error(Exception(response.message()))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override val keyReuseSupported: Boolean
        get() = true
}
