package bilulo.com.jetpackproject.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import bilulo.com.jetpackproject.data.model.Album
import bilulo.com.jetpackproject.utils.DateConverters
import javax.inject.Singleton

@Database (entities = [Album::class], version = 1)
@TypeConverters(DateConverters::class)
@Singleton
abstract class AlbumDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
}