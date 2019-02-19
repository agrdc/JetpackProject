package bilulo.com.jetpackproject.data.model

import com.google.gson.annotations.SerializedName

data class AlbumsObject(
    @field:SerializedName("albums")
    val albumsList : List<Album> )