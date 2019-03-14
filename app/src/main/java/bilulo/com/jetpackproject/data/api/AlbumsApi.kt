package bilulo.com.jetpackproject.data.api

import bilulo.com.jetpackproject.data.model.AlbumsObject
import retrofit2.Call
import retrofit2.http.GET

interface AlbumsApi {
    @GET("/v2/5c8acd9e2e0000bf56d64e17")
    fun getAlbums() : Call<AlbumsObject>
}
