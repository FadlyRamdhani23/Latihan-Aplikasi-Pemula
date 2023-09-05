package org.d3if3127.dicoding

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListBurungAdapter(private val listBurung: ArrayList<Burung>) : RecyclerView.Adapter<ListBurungAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_burung, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listBurung.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, makanan) = listBurung[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val moveWithObjectIntent = Intent(context, DetailActivity::class.java)
            moveWithObjectIntent.putExtra(DetailActivity.EXTRA_BURUNG, listBurung[holder.adapterPosition])
            context.startActivity(moveWithObjectIntent)

        }
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Burung)
    }
}