package bilulo.com.jetpackproject.ui.list.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bilulo.com.jetpackproject.data.model.Album
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import bilulo.com.jetpackproject.R
import kotlinx.android.synthetic.main.list_item.view.*


class ListAdapter : RecyclerView.Adapter<ListAdapter.AlbumViewHolder>() {

    lateinit var mData: List<Album>
    lateinit var mContext: Context
    var onItemClick: ((Album) -> Unit)? = null

    fun setData(albumList: List<Album>) {
        mData = albumList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.AlbumViewHolder {
        mContext = parent.context
        val itemView: View = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false)
        return AlbumViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ListAdapter.AlbumViewHolder, position: Int) {
        val album = mData[position]
        holder.name.text = album.name
        //holder.albumCover =
        holder.artistName.text = album.artist
        holder.description.text = album.description

    }

    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.nameTextView
        val albumCover : ImageView = itemView.albumCoverImageView
        val artistName : TextView = itemView.artistNameTextView
        val releaseDate : TextView = itemView.releaseDateTextView
        val description : TextView = itemView.descriptionTextView

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }
    }

}