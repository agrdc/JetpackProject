package bilulo.com.jetpackproject.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import bilulo.com.jetpackproject.data.model.Album

@Dao
interface AlbumDao {
    @Query("SELECT * FROM album")
    fun getAll(): List<Album>?

    @Query("SELECT * FROM album WHERE id == 1 LIMIT 1")
    fun getFirst(): Album?

    @Query("SELECT * FROM album WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Album

    @Insert(onConflict = REPLACE)
    fun insert(vararg album: Album)

    @Insert(onConflict = REPLACE)
    fun insertAll(albumList: List<Album>)

    @Delete
    fun delete(album: Album)
}