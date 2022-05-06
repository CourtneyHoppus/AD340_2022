package com.hoppus.ad340

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val extras = intent.extras

        val title = extras!!.getString("TITLE") as String
        val year = extras.getString("YEAR") as String
        val director = extras.getString("DIRECTOR") as String
        val description = extras.getString("DESCRIPTION") as String

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewDetail)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MovieDetailAdapter(title, year, director, description)
        recyclerView.adapter = adapter
    }
}
