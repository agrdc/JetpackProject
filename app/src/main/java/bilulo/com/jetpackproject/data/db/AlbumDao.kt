package bilulo.com.jetpackproject.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import bilulo.com.jetpackproject.data.model.Album
import java.util.*

@Dao
interface AlbumDao {
    @Query("SELECT * FROM album")
    fun getAll(): LiveData<List<Album>>

    @Query("SELECT * FROM album WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): LiveData<Album>

    @Insert
    fun insert(vararg album: Album)

    @Delete
    fun delete(album:Album)
}