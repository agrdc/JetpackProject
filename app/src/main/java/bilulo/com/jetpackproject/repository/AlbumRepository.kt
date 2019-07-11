package bilulo.com.jetpackproject.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import bilulo.com.jetpackproject.data.api.AlbumsService
import bilulo.com.jetpackproject.data.api.IAlbumsResponse
import bilulo.com.jetpackproject.data.db.AlbumDao
import bilulo.com.jetpackproject.data.db.AlbumDatabase
import bilulo.com.jetpackproject.data.enumerators.ResponseErrorEnum
import bilulo.com.jetpackproject.data.model.Album
import bilulo.com.jetpackproject.data.model.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.threeten.bp.OffsetDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlbumRepository @Inject constructor(var albumsService: AlbumsService, var applicationContext: Context) {

    fun fetchAlbums(): LiveData<Resource<List<Album>?>> {
        val albumDao = AlbumDatabase.get(applicationContext).albumDao()
        val albumResource = MutableLiveData<Resource<List<Album>?>>()
        if (shouldFetch(albumDao.getFirst())) {
            val albumList = MutableLiveData<List<Album>?>()
            albumResource.value = Resource.loading(albumList.value)
            albumsService.fetchAlbums(object : IAlbumsResponse<List<Album>?> {
                override fun onResponseSuccess(response: List<Album>?) {
                    if (response != null) {
                        setLastRefreshDates(response)
                        albumList.value = response
                        saveListOnDatabase(albumDao, albumList.value!!)
                        albumResource.value = Resource.success(albumList.value)
                    } else {
                        albumResource.value = Resource.error(ResponseErrorEnum.GENERAL.message, albumList.value)
                    }
                }

                override fun onResponseNotFound() {
                    albumResource.value = Resource.error(ResponseErrorEnum.NOT_FOUND.message, albumList.value)
                }

                override fun onResponseError() {
                    albumResource.value = Resource.error(ResponseErrorEnum.GENERAL.message, albumList.value)
                }
            })
        } else {
            albumResource.value = Resource.success(albumDao.getAll())
        }
        return albumResource
    }

    private fun saveListOnDatabase(albumDao: AlbumDao, albumList: List<Album>) {
        GlobalScope.launch { async(Dispatchers.IO) { albumDao.insertAll(albumList) } }
    }

    private fun shouldFetch(album: Album?): Boolean {
        if (album != null) {
            val futureRefDate = album.lastRefreshDate?.plus(1, org.threeten.bp.temporal.ChronoUnit.HOURS)
            if (futureRefDate != null) {
                return futureRefDate.isBefore(OffsetDateTime.now())
            }
        }
        return true
    }

    private fun setLastRefreshDates(response: List<Album>) {
        if (response.isNotEmpty()) {
            for (album: Album in response) {
                album.lastRefreshDate = OffsetDateTime.now()
            }
        }
    }
}