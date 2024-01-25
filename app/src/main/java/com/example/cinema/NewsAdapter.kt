package com.example.cinema

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinema.retrofit.model.DataMovie

class NewsAdapter(val context: Context,
                  private val list: MutableList<DataMovie>,
                  private val listener: NewsAdapterEvents
): RecyclerView.Adapter<NewsAdapter.Link>() {
    inner class Link(item: View): RecyclerView.ViewHolder(item), View.OnClickListener {
        val name: TextView = item.findViewById(R.id.nameNews)
        val image: ImageView = item.findViewById(R.id.imageUrlNews)
        val bio: TextView = item.findViewById(R.id.bioNews)

        init {
            item.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Link {
        val root = LayoutInflater.from(context).inflate(R.layout.recycler_news, parent, false)
        return Link(root)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Link, position: Int) {
        holder.name.text = list[position].name
        Glide.with(context).load(list[position].imageurl).into(holder.image)
        holder.bio.text = list[position].bio
    }
}