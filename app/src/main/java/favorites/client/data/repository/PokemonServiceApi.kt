package favorites.client.data.repository



import favorites.client.data.models.pokemondetails.PokemonDetailsResponse
import favorites.client.data.models.pokemonlist.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


//TODO: Figure out favorites response lol
//interface FavoritesServiceApi {
//    @GET(value = "/favorites/")
//    suspend fun getBusinesses(
//    ): Response<>
//}

interface PokemonServiceApi {
    @GET(value = "/")
    suspend fun getPokemon(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<PokemonListResponse>

    @GET(value="/{id}/")
    suspend fun getPokemonDetailsById(
        @Path("id") id: Int
    ): Response<PokemonDetailsResponse>

    @GET(value="/{name}/")
    suspend fun getPokemonDetailsByName(
        @Path("name") name: String
    ):Response<PokemonDetailsResponse>
}