package bilulo.com.jetpackproject.data.api

import bilulo.com.jetpackproject.data.model.AlbumsObject
import retrofit2.Call
import retrofit2.http.GET

interface AlbumsApi {
    @GET("/v2/5d02a1d33100004f4aab30df")
    fun getAlbums() : Call<AlbumsObject>
}
