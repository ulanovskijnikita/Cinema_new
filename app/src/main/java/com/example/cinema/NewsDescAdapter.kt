package com.example.cinema

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.retrofit.model.DataMovie

class NewsDescAdapter(val context: Context, val list: MutableList<DataMovie>):RecyclerView.Adapter<NewsDescAdapter.Link>() {
    class Link(view: View): RecyclerView.ViewHolder(view) {
        val realname: TextView = view.findViewById(R.id.realname)
        val team: TextView = view.findViewById(R.id.team)
        val firstappearance: TextView = view.findViewById(R.id.firstappearance)
        val createdby: TextView = view.findViewById(R.id.createdby)
        val publisher: TextView = view.findViewById(R.id.publisher)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Link {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: Link, position: Int) {
        TODO("Not yet implemented")
    }

}