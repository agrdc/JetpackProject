package bilulo.com.jetpackproject.data.api

import bilulo.com.jetpackproject.data.model.Album
import bilulo.com.jetpackproject.data.model.AlbumsObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class AlbumsService @Inject constructor() {
    private val albumsApi = RetrofitInitializer.getAlbumsApi()
    fun fetchAlbums(listener: IAlbumsResponse<List<Album>?>) {
        albumsApi.getAlbums().enqueue(object : Callback<AlbumsObject> {
            override fun onResponse(call: Call<AlbumsObject>, response: Response<AlbumsObject>) {
                response.let {
                    when {
                        response.isSuccessful -> {
                            val albumsList = response.body()?.albumsList
                            if (albumsList != null && albumsList.isNotEmpty())
                                listener.onResponseSuccess(albumsList)
                            else
                                listener.onResponseError()
                        }
                        else -> {
                            Timber.d(response.errorBody().toString())
                            listener.onResponseError()
                        }
                    }
                }
            }

            @Override
            override fun onFailure(call: Call<AlbumsObject>, t: Throwable) {
                Timber.e(t)
                listener.onResponseError()
            }
        })
    }

}