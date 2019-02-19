package bilulo.com.jetpackproject.repository

import androidx.lifecycle.LiveData
import bilulo.com.jetpackproject.data.api.AlbumsService
import bilulo.com.jetpackproject.data.api.IAlbumsResponse
import bilulo.com.jetpackproject.data.model.Album
import javax.inject.Inject
import javax.inject.Singleton
import androidx.lifecycle.MutableLiveData

@Singleton
class AlbumRepository @Inject constructor(var albumsService: AlbumsService) {

        fun fetchAlbums() : LiveData<List<Album>> {
            val albumList = MutableLiveData<List<Album>>()
            albumsService.fetchAlbums(object : IAlbumsResponse<List<Album>?> {
                override fun onResponseSuccess(response: List<Album>?) {
                    albumList.value = response
                }
                override fun onResponseNotFound() {
                    //TODO
                }
                override fun onResponseError() {
                    //TODO
                }
            })
            return albumList
        }
}