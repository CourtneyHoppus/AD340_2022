package com.hoppus.ad340

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.GridView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView
    private var buttonNames = arrayOf("button 1", "button 2", "button 3", "button 4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            Log.d("click", button.text as String)
            val intent = Intent(this, AboutActivity::class.java)
            intent.putExtra("info", "passed info")
            startActivity(intent)
            Toast.makeText(this, "You clicked " + button.text, Toast.LENGTH_SHORT).show()
        }

        gridView = findViewById(R.id.gridView)
        val mainAdapter = MainAdapter(this, buttonNames)
        gridView.adapter = mainAdapter

    }
}
