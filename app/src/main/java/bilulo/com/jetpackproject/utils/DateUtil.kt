package bilulo.com.jetpackproject.utils

import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

class DateUtil {
    companion object {
        fun formatDateFromString(desiredPattern: String, initialPattern: String, dateString: String): String {
            val data = formatStringToDate(initialPattern, dateString)
            return if (data != null)
                formatDate(desiredPattern, data)
            else ""
        }

        fun formatStringToDate(formatPattern: String, date: String): Date? {
            val format = SimpleDateFormat(formatPattern, Locale("pt", "BR"))
            return try {
                format.parse(date)
            } catch (e: Exception) {
                Timber.e(e)
                null
            }
        }

        fun formatDate(formatPattern: String, date: Date): String {
            return try {
                val format = SimpleDateFormat(formatPattern, Locale("pt", "BR"))
                format.format(date)
            } catch (e: Exception) {
                Timber.e(e)
                ""
            }
        }
    }
}