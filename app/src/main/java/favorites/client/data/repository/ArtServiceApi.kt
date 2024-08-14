package favorites.client.data.repository



import favorites.client.data.models.ArtResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query



interface ArtServiceApi {
    @GET(value = "/")
    suspend fun getArtworks(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("query") query: String
    ): Response<ArtResponse>


//    @GET(value="pokemon/{id}/")
//    suspend fun getPokemonDetailsById(
//        @Path("id") id: Int
//    ): Response<PokemonDetailsResponse>
//
//    @GET(value="pokemon/{name}/")
//    suspend fun getPokemonDetailsByName(
//        @Path("name") name: String
//    ):Response<PokemonDetailsResponse>
}