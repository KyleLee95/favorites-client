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
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("fields") fields: String,
    ): Response<ArtResponse>

}

//id,
//title,
//image_id,
//alt_titles,
//artist_display,
//dimensions,
//dimensions_detail,
//medium_display,
//place_of_origin,gallery_title,
//style_title,
//classication_title,
//exhibition_history,
//api_model,
//api_link,
//config