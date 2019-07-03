package bilulo.com.jetpackproject.data.api

import bilulo.com.jetpackproject.data.model.AlbumsObject
import retrofit2.Call
import retrofit2.http.GET

interface AlbumsApi {
    @GET("/v2/5d1d0fcc3400001fb1b60208")
    fun getAlbums() : Call<AlbumsObject>
}
