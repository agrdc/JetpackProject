package bilulo.com.jetpackproject.utils

import androidx.room.TypeConverter
import java.util.*


class DateConverters {
    companion object {
        @JvmStatic
        @TypeConverter
        fun toTimestamp(date: Date?): Long? {
            return date?.time
        }

        @JvmStatic
        @TypeConverter
        fun timestampToDate(timestamp: Long?): Date? {
            return (timestamp?.let { Date(it) })
        }
    }
}