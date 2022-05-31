package com.hoppus.ad340

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TrafficCamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traffic_cam)

        val actionBar = supportActionBar
        actionBar!!.title = intent.getStringExtra(EXTRA_MESSAGE)
        actionBar.setDisplayHomeAsUpEnabled(true)

        if (Utilities.isConnected(this)) {
            Log.d("CONNECTION", "Connected")
            TrafficCamModel.loadData(this) { data ->
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                recyclerView.layoutManager = LinearLayoutManager(this)
                val adapter = TrafficCamAdapter(data)
                recyclerView.adapter = adapter
            }
        }
        else {
            Log.d("CONNECTION", "Not Connected")
            setContentView(R.layout.activity_display_message)
            findViewById<TextView>(R.id.textView).apply {
                context.getString(R.string.noConnection).also { text = it }
            }
        }
    }
}
