package favorites.client.presentation.screens.search.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import favorites.client.data.models.artworks.Datum
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
            val currentPage = params.key ?: 1


            val response = artRepository.getArtwork(
                limit = params.loadSize,
                page = currentPage,
                offset = (currentPage-1) * params.loadSize,
                query = paginateData.query,
                fields = paginateData.fields
            )

            if (response.isSuccessful) {
                val body = response.body()?.data ?: emptyList()
                val pagination = response.body()?.pagination
                val nextKey = if (pagination?.currentPage ?: 0 < pagination?.totalPages ?: 0) {
                    currentPage + 1
                } else {
                    null
                }



                LoadResult.Page(
                    data = body!!,
                    prevKey = if (currentPage == 1) null else currentPage- 1,
                    nextKey = nextKey
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
