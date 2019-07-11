package bilulo.com.jetpackproject.ui.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import bilulo.com.jetpackproject.data.model.Album
import bilulo.com.jetpackproject.data.model.Resource
import bilulo.com.jetpackproject.repository.AlbumRepository
import javax.inject.Inject

class ListViewModel @Inject constructor(var albumRepository: AlbumRepository) : ViewModel() {

    private lateinit var albumResource: LiveData<Resource<List<Album>?>>
    private lateinit var albumPagedList: LiveData<PagedList<Album>>

    fun init() {
        albumResource = albumRepository.fetchAlbums()
        //albumPagedList = LivePagedListBuilder(albumRepository.fetchAlbums(), PAGE_SIZE).build()
    }

    fun albumResource(): LiveData<Resource<List<Album>?>> {
        return albumResource
    }

    companion object {
        private const val PAGE_SIZE = 10
    }
}