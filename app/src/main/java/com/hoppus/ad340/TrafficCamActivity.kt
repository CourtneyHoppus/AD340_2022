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

        val dataHardCoded = ArrayList<TrafficCamModel>()
        val addresses : Array<Array<String>> = arrayOf(
            arrayOf("Fauntleroy Way SW & SW Cloverdale St",
                "Fauntleroy_SW_Cloverdale_NS.jpg",
                "sdot"),
            arrayOf("24th Ave NW & NW Market St",
                "24_NW_Market_EW.jpg",
                "sdot"),
            arrayOf("42nd Ave SW & SW Alaska S",
                "42_SW_Alaska_EW.jpg",
                "sdot"),
            arrayOf("I-5 @ Marine View Dr",
                "005vc19469.jpg",
                "wsdot")
        )
        for (address in addresses)
            dataHardCoded.add(TrafficCamModel(address[0], address[1], address[2]))

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = TrafficCamAdapter(dataHardCoded)
        recyclerView.adapter = adapter
    }
}
