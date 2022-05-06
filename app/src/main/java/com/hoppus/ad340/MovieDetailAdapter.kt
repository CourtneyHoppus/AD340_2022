package com.hoppus.ad340

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieDetailAdapter(
    private val title: String,
    private val year: String,
    private val director: String,
    private val description: String
) : RecyclerView.Adapter<MovieDetailAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movie_detail_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.movieTitleView.text = title
        holder.movieYearView.text = year
        holder.movieDirectorView.text = director
        holder.movieDescriptionView.text = description
    }

    override fun getItemCount(): Int {
        return 1
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val movieTitleView: TextView = itemView.findViewById(R.id.movieTitleView)
        val movieYearView: TextView = itemView.findViewById(R.id.movieYearView)
        val movieDirectorView: TextView = itemView.findViewById(R.id.movieDirectorView)
        val movieDescriptionView: TextView = itemView.findViewById(R.id.movieDescriptionView)
    }

}