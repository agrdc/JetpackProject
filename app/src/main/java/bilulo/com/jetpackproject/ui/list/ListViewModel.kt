package bilulo.com.jetpackproject.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import bilulo.com.jetpackproject.data.model.Album
import bilulo.com.jetpackproject.repository.AlbumRepository
import javax.inject.Inject

class ListViewModel @Inject constructor(var albumRepository: AlbumRepository) : ViewModel() {

    private lateinit var albumList: LiveData<List<Album>>

    public fun init() {
        albumList = albumRepository.getAlbums()
    }

    fun albumList(): LiveData<List<Album>> {
        return albumList
    }
}