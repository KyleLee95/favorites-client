package favorites.client.data.repository

import favorites.client.common.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AuthInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader("accept", "application/json")
            .build()
        return chain.proceed(newRequest)
    }
}


object ApiProvider {
    fun favoritesApi(): FavoritesServiceApi {
        return Retrofit.Builder()
            .baseUrl(Constants.favoritesServiceBaseUrl)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FavoritesServiceApi::class.java)
    }


    fun pokemonApi(): PokemonServiceApi {
        return Retrofit.Builder()
            .baseUrl(Constants.pokemonapiServiceBaseUrl)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonServiceApi::class.java)
    }

    fun loggingApi(): LoggingServiceApi{
        return Retrofit.Builder()
            .baseUrl(Constants.loggingServiceBaseUrl)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoggingServiceApi::class.java)
    }


    fun artApi(): ArtServiceApi{
        return Retrofit.Builder()
            .baseUrl(Constants.artApiServiceBaseUrl)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ArtServiceApi::class.java)
    }

    private val authHeadersInterceptor = AuthInterceptor()


    private fun getOkHttpClient() =
        OkHttpClient.Builder().addInterceptor(getLoggingInterceptor()).addInterceptor(
            authHeadersInterceptor
        ).build()

    //todo set HttpLoggingInterceptor.Level.BODY to HttpLoggingInterceptor.Level.NONE for production release
    private fun getLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

}