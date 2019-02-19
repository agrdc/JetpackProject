package bilulo.com.jetpackproject.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import bilulo.com.jetpackproject.data.model.Album
import bilulo.com.jetpackproject.repository.AlbumRepository
import javax.inject.Inject

class ListViewModel @Inject constructor(var albumRepository: AlbumRepository) : ViewModel() {

    private lateinit var albumList: LiveData<List<Album>>

    fun init() {
        albumList = albumRepository.fetchAlbums()
    }

    fun albumList(): LiveData<List<Album>> {
        return albumList
    }
}