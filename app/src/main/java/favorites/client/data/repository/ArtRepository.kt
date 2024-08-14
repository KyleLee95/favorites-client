package favorites.client.data.repository

import favorites.client.data.models.ArtResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ArtRepository(private val artServiceApi: ArtServiceApi) {

    // get "page" of pokemon. A list that's offset by the amount of pokemona already loaded
    suspend fun getArtwork(limit: Int, page: Int, query: String): Response<ArtResponse> {
        return withContext(Dispatchers.IO) {
            artServiceApi.getArtworks(limit = limit, page=page, query= query)
        }
    }

//    // get a pokemon by its ID
//    suspend fun getPokemonDetailsById(id: Int): Response<PokemonDetailsResponse> {
//        return withContext(Dispatchers.IO) {
//            pokemonServiceApi.getPokemonDetailsById(id)
//        }
//    }
//
//    // get a pokemon by its name
//    suspend fun getPokemonByName(name: String): Response<PokemonDetailsResponse>{
//        return withContext(Dispatchers.IO){
//            pokemonServiceApi.getPokemonDetailsByName(name)
//        }
//    }
}
