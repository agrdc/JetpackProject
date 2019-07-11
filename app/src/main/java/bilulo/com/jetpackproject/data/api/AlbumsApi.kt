package bilulo.com.jetpackproject.data.api

import bilulo.com.jetpackproject.data.model.AlbumsObject
import retrofit2.Call
import retrofit2.http.GET

interface AlbumsApi {
    @GET("/v2/5d1f5255310000109bebeccb")
    fun getAlbums() : Call<AlbumsObject>
}
