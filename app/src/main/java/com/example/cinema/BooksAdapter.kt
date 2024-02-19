package com.example.cinema

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinema.databinding.FragmentBooksBinding
import com.example.cinema.databinding.RecyclerBooksBinding
import com.example.cinema.retrofit.model.DataBooks
import com.example.cinema.retrofit.model.DataCharacters

class BooksAdapter(private val listBooks: List<DataBooks>)
    :RecyclerView.Adapter<BooksAdapter.Link>() {
    class Link(item: View): RecyclerView.ViewHolder(item) {
        val titleBooks: TextView = item.findViewById(R.id.titleBooks)
        val releaseDayBooks: TextView = item.findViewById(R.id.releaseDayBooks)

//        val imageBooks: ImageView = item.findViewById(R.id.imageBooks)
//        val characterBooks: TextView = item.findViewById(R.id.characterBooks)
//        val hogwartsHouseBooks: TextView = item.findViewById(R.id.hogwartsHouseBooks)
//
//        val imageBooks1: ImageView = item.findViewById(R.id.imageBooks1)
//        val characterBooks1: TextView = item.findViewById(R.id.characterBooks1)
//        val hogwartsHouseBooks1: TextView = item.findViewById(R.id.hogwartsHouseBooks1)
//
//        val imageBooks2: ImageView = item.findViewById(R.id.imageBooks2)
//        val characterBooks2: TextView = item.findViewById(R.id.characterBooks2)
//        val hogwartsHouseBooks2: TextView = item.findViewById(R.id.hogwartsHouseBooks2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Link {
        val root = RecyclerBooksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Link(root.root)
    }

    override fun getItemCount(): Int {
        return listBooks.size
    }

    override fun onBindViewHolder(holder: Link, position: Int) {
        holder.titleBooks.setText(listBooks[position].title)
        holder.releaseDayBooks.setText(listBooks[position].releaseDay)

////        Glide.with(context).load(listCharacters[position].image).into(holder.imageBooks)
//        holder.characterBooks.setText(listCharacters[position].character)
//        holder.hogwartsHouseBooks.setText(listCharacters[position].hogwartsHouse)
//
////        Glide.with(context).load(listCharacters[position + 1].image).into(holder.imageBooks1)
//        holder.characterBooks1.setText(listCharacters[position + 1].character)
//        holder.hogwartsHouseBooks1.setText(listCharacters[position + 1].hogwartsHouse)
//
////        Glide.with(context).load(listCharacters[position + 2].image).into(holder.imageBooks2)
//        holder.characterBooks2.setText(listCharacters[position + 2].character)
//        holder.hogwartsHouseBooks2.setText(listCharacters[position + 2].hogwartsHouse)
    }
}