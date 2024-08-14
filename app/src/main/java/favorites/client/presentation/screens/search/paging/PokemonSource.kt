package favorites.client.presentation.screens.search.paging


import androidx.paging.PagingSource
import androidx.paging.PagingState
import favorites.client.data.models.pokemonlist.Result
import favorites.client.data.repository.PokemonRepository

class PokemonSource(
    private val pokemonRepository: PokemonRepository,
    private val paginateData: Paginate
) : PagingSource<Int, Result>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val position = params.key ?: 0

        return try {
            // Fetch Pokémon list from the repository
            val response = pokemonRepository.getPokemon(position, params.loadSize)
            val pokemonList = response.body()

            // Extract the list of results (individual Pokémon items)
            val pokemonResults = pokemonList?.results ?: emptyList()

            // Determine the next and previous keys (for pagination)
            val nextKey = if (pokemonResults.isEmpty()) null else position + params.loadSize
            val prevKey = if (position == 0) null else position - params.loadSize

            LoadResult.Page(
                data = pokemonResults,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        // Returning the key that should be used for the initial load when the refresh is triggered
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
