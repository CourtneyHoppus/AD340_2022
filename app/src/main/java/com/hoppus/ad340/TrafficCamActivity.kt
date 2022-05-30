package com.hoppus.ad340

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TrafficCamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traffic_cam)

        val actionBar = supportActionBar
        actionBar!!.title = intent.getStringExtra(EXTRA_MESSAGE)
        actionBar.setDisplayHomeAsUpEnabled(true)

        TrafficCamModel.loadData(this) { data ->
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            val adapter = TrafficCamAdapter(data)
            recyclerView.adapter = adapter
        }
    }
}
