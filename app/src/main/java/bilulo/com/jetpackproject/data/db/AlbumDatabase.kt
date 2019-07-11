package bilulo.com.jetpackproject.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import bilulo.com.jetpackproject.data.model.Album
import javax.inject.Singleton

@Database(entities = [Album::class], version = 1)
@Singleton
abstract class AlbumDatabase : RoomDatabase() {

    abstract fun albumDao(): AlbumDao
    
    companion object {
        private var instance: AlbumDatabase? = null
        @Synchronized
        fun get(context: Context): AlbumDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AlbumDatabase::class.java, "AlbumDatabase"
                ).allowMainThreadQueries().build()
            }
            return instance!!
        }
    }
}