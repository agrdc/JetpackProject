package bilulo.com.jetpackproject.data.api

import bilulo.com.jetpackproject.data.model.Album
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumsService {
    companion object {
        private val albumsApi = RetrofitInitializer.getAlbumsApi()

        fun getAlbums(listener: IAlbumsResponse<List<Album>?>) {
            albumsApi.getAlbums().enqueue(object : Callback<List<Album>> {
                override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                    response.let {
                        when {
                            response.isSuccessful -> listener.onResponseSuccess(response.body())
                            else -> if (response.code() == 404)
                                listener.onResponseNotFound()
                            else
                                listener.onResponseError(response.errorBody().toString())
                        }
                    }
                }

                @Override
                override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                    listener.onResponseError(t.stackTrace.toString())
                }
            })
        }
    }
}