package bilulo.com.jetpackproject.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
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
    val description: String?
)