package favorites.presentation.screens.search.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
//import favorites.data.repository.BusinessRepository

class BusinessSource(){}
//    private val businessRepository: BusinessRepository,
//    private val paginateData: Paginate
//) : PagingSource<Int, Business>() {
//
//    override fun getRefreshKey(state: PagingState<Int, Business>): Int? {
//        return state.anchorPosition?.let { anchorPosition ->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage?.prevKey?.plus(other = 1) ?: anchorPage?.nextKey?.minus(other = 1)
//
//        }
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Business> {
//        return try {
//            val prev = params.key ?: 0
//            val response = businessRepository.getBusinesses(
//                location = paginateData.location,
//                term = paginateData.term,
//                offset = prev,
//                limit = params.loadSize
//            )
//
//            if (response.isSuccessful) {
//
//                val body = response.body()?.businesses
//
//                LoadResult.Page(
//                    data = body!!,
//                    prevKey = if (prev == 0) null else prev - 1,
//                    nextKey = if (body.size < params.loadSize) null else prev + 10
//                )
//
//            } else {
//                LoadResult.Error(Exception(response.message()))
//            }
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
//    }
//
//    override val keyReuseSupported: Boolean
//        get() = true
//
//}