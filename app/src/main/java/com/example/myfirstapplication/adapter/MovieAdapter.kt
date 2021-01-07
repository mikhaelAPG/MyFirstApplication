package com.example.myfirstapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.R
import com.example.myfirstapplication.model.Movie

class MovieAdapter(val context: Context): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val movies: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        holder.bindModel(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun setMovie(data: List<Movie>) {
        movies.clear()
        movies.addAll(data)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(item: View): RecyclerView.ViewHolder(item) {

        val txtTitle: TextView = item.findViewById(R.id.tv_judul)
        val txtDescription: TextView = item.findViewById(R.id.tv_deskripsi)

        fun bindModel(m: Movie) {
            txtTitle.text = m.getTitle()
            txtDescription.text = m.getDescription()
        }
    }
}