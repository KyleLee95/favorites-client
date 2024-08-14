package favorites.client.data.repository

import androidx.compose.ui.geometry.Offset
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import favorites.client.data.models.pokemondetails.PokemonDetailsResponse
import favorites.client.data.models.pokemonlist.PokemonListResponse

class PokemonRepository(private val pokemonServiceApi: PokemonServiceApi) {

    // get "page" of pokemon. A list that's offset by the amount of pokemona already loaded
    suspend fun getPokemon(limit: Int, offset: Int): Response<PokemonListResponse> {
        return withContext(Dispatchers.IO) {
            pokemonServiceApi.getPokemon(limit, offset)
        }
    }

    // get a pokemon by its ID
    suspend fun getPokemonDetailsById(id: Int): Response<PokemonDetailsResponse> {
        return withContext(Dispatchers.IO) {
            pokemonServiceApi.getPokemonDetailsById(id)
        }
    }

    // get a pokemon by its name
    suspend fun getPokemonByName(name: String): Response<PokemonDetailsResponse>{
        return withContext(Dispatchers.IO){
            pokemonServiceApi.getPokemonDetailsByName(name)
        }
    }
}