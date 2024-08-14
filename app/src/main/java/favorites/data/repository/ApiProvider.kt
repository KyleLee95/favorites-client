package favorites.data.repository

import favorites.common.Constants
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
    fun favoritesApi(): FavoritesApi {
        return Retrofit.Builder()
            .baseUrl(Constants.favoritesServiceBaseUrl)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FavoritesApi::class.java)
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