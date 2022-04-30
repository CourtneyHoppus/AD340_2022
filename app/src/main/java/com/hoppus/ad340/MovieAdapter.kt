package com.hoppus.ad340

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(
    private val movieList: List<MovieViewModel>
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movie_card_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieViewModel = movieList[position]
        holder.movieTextView.text = movieViewModel.text
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val movieTextView: TextView = itemView.findViewById(R.id.movieTextView)
    }

}