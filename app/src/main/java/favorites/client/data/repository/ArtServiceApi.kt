package favorites.client.data.repository



import favorites.client.data.models.ArtResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query



interface ArtServiceApi {
    @GET(value = "artworks/search")
    suspend fun getArtworks(
        @Query("query") q: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<ArtResponse>

}