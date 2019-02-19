package bilulo.com.jetpackproject.data.api

import bilulo.com.jetpackproject.data.model.AlbumsObject
import retrofit2.Call
import retrofit2.http.GET

interface AlbumsApi {
    @GET("/v2/5c6467ea3200006c5093f996")
    fun getAlbums() : Call<AlbumsObject>
}
