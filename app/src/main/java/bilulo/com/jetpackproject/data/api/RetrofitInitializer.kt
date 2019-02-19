package bilulo.com.jetpackproject.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.R
import android.content.Context
import java.security.KeyStore
import java.security.cert.CertificateFactory
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager


object RetrofitInitializer {

    private val loggingInterceptor = HttpLoggingInterceptor()
    private val httpClientBuilder = OkHttpClient.Builder()

    private lateinit var retrofit : Retrofit

    fun getAlbumsApi(): AlbumsApi{
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClientBuilder.addInterceptor(loggingInterceptor)
        var httpClient = httpClientBuilder.build()
        retrofit = Retrofit.Builder()
            .baseUrl("http://www.mocky.io/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(AlbumsApi::class.java)
    }

    /*
    private fun buildHttpClient(context: Context): OkHttpClient {
        // Load CAs from an InputStream
        val certificateFactory = CertificateFactory.getInstance("X.509")

        val inputStream = context.getResources().openRawResource(R.raw.ssl_certificate) //(.crt)
        val certificate = certificateFactory.generateCertificate(inputStream)
        inputStream.close()

        // Create a KeyStore containing our trusted CAs
        val keyStoreType = KeyStore.getDefaultType()
        val keyStore = KeyStore.getInstance(keyStoreType)
        keyStore.load(null, null)
        keyStore.setCertificateEntry("ca", certificate)

        // Create a TrustManager that trusts the CAs in our KeyStore.
        val tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm()
        val trustManagerFactory = TrustManagerFactory.getInstance(tmfAlgorithm)
        trustManagerFactory.init(keyStore)

        val trustManagers = trustManagerFactory.getTrustManagers()
        val x509TrustManager = trustManagers[0] as X509TrustManager


        // Create an SSLSocketFactory that uses our TrustManager
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, arrayOf<TrustManager>(x509TrustManager), null)
        sslSocketFactory = sslContext.socketFactory

        // Create loggin interceptor
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        //return Okhttp client
        return OkHttpClient.Builder()
            .sslSocketFactory(sslSocketFactory, x509TrustManager)
            .addInterceptor(loggingInterceptor)
            .build()
    } */
}