package bilulo.com.jetpackproject.data.model

import androidx.room.*
import bilulo.com.jetpackproject.utils.DateConverter
import com.google.gson.annotations.SerializedName
import org.threeten.bp.OffsetDateTime

@Entity
@TypeConverters(DateConverter::class)
data class Album (
    @field:SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Int?,
    @field:SerializedName("name")
    @ColumnInfo(name = "name")
    val name: String?,
    @field:SerializedName("artist")
    @ColumnInfo(name = "artist")
    val artist: String?,
    @field:SerializedName("release_date")
    @ColumnInfo(name = "release_date")
    val releaseDate: String?,
    @field:SerializedName("cover_url")
    @ColumnInfo(name = "cover_url")
    val coverUrl: String?,
    @field:SerializedName("description")
    @ColumnInfo(name = "description")
    val description: String?,
    @ColumnInfo(name = "last_refresh_date")
    var lastRefreshDate: OffsetDateTime?
)