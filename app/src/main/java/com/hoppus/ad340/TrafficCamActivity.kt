package com.hoppus.ad340

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TrafficCamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traffic_cam)

        val actionBar = supportActionBar
        actionBar!!.title = intent.getStringExtra(EXTRA_MESSAGE)
        actionBar.setDisplayHomeAsUpEnabled(true)

        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }
    }
}
