package bilulo.com.jetpackproject.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import bilulo.com.jetpackproject.data.model.Album

class ListViewModel : ViewModel() {
    private lateinit var albumList : LiveData<List<Album>>

    public fun init() {

    }

    fun albumList() : LiveData<List<Album>> {
        return albumList
    }
}