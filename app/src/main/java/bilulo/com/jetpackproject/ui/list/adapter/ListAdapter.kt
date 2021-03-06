package bilulo.com.jetpackproject.ui.list.adapter

import android.content.Context
import android.net.Uri
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bilulo.com.jetpackproject.data.model.Album
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import bilulo.com.jetpackproject.R
import bilulo.com.jetpackproject.utils.DateUtil
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*
import timber.log.Timber


class ListAdapter : RecyclerView.Adapter<ListAdapter.AlbumViewHolder>() {

    var mData: List<Album>? = null
    var onItemClick: ((Album?) -> Unit)? = null

    fun setData(albumList: List<Album>?) {
        mData = albumList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.AlbumViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return AlbumViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        if (mData == null)
            return 0
        else
            return mData!!.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = mData?.get(position)
        holder.name.text = album?.name
        holder.artistName.text = album?.artist
        holder.description.text = album?.description
        val releaseDate = album?.releaseDate
        if (releaseDate != null) {
            val formattedDate = DateUtil.formatDateFromString("dd/MM/yyyy", "yyyy-MM-dd", releaseDate)
            holder.releaseDate.text = formattedDate
        }
        try {
            val coverUri = Uri.parse(album?.coverUrl)
            Glide.with(holder.itemView.context).load(coverUri).into(holder.albumCover)
        } catch (error: Exception) {
            Timber.e(error)
        }

    }

    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.nameTextView
        val albumCover: ImageView = itemView.albumCoverImageView
        val artistName: TextView = itemView.artistNameTextView
        val releaseDate: TextView = itemView.releaseDateTextView
        val description: TextView = itemView.descriptionTextView

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(mData?.get(adapterPosition))
            }
        }
    }

}