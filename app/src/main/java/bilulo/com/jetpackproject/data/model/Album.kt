package bilulo.com.jetpackproject.data.model

import com.google.gson.annotations.SerializedName

data class Album (
    @field:SerializedName("id")
    val id: Int?,
    @field:SerializedName("name")
    val name: String?,
    @field:SerializedName("artist")
    val artist: String?,
    @field:SerializedName("release_date")
    val release_date: String?,
    @field:SerializedName("cover_url")
    val cover_url: String?,
    @field:SerializedName("description")
    val description: String?
)