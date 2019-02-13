package bilulo.com.jetpackproject.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInitializer {

    private val loggingInterceptor = HttpLoggingInterceptor()
    private val httpClientBuilder = OkHttpClient.Builder()

    private lateinit var retrofit : Retrofit

    fun getAlbumsApi(): AlbumsApi{
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClientBuilder.addInterceptor(loggingInterceptor)
        var httpClient = httpClientBuilder.build()
        retrofit = Retrofit.Builder()
            .baseUrl("https://www.mocky.io/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(AlbumsApi::class.java)
    }
}