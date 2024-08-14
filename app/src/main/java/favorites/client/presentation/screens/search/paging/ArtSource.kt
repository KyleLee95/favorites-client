package favorites.client.presentation.screens.search.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import favorites.client.data.models.Datum
import favorites.client.data.repository.ArtRepository

class ArtSource (
    private val artRepository: ArtRepository,
    private val paginateData: Paginate
) :
    PagingSource<Int, Datum>() {
    override fun getRefreshKey(state: PagingState<Int, Datum>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Datum> {
        return try {
            val prev = params.key ?: 0

            val response = artRepository.getArtwork(
                limit = 10,
                page = paginateData.page,
                query = paginateData.query
            )

            if (response.isSuccessful) {
                val body = response.body()?.data
                LoadResult.Page(
                    data = body!!,
                    prevKey = if (prev == 0) null else prev - 1,
                    nextKey = if (body.size < params.loadSize) null else prev + 10
                )
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
