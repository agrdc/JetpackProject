package bilulo.com.jetpackproject.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import bilulo.com.jetpackproject.data.model.Album
import javax.inject.Singleton

@Database (entities = [Album::class], version = 1)
@Singleton
abstract class AlbumDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
}