package com.hoppus.ad340

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.GridView
import android.widget.Toast

const val EXTRA_MESSAGE = "com.hoppus.ad340.MESSAGE"

class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView
    private var buttonNames = arrayOf("button 1", "button 2", "button 3", "button 4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.gridView)
        val mainAdapter = MainAdapter(this, buttonNames)
        gridView.adapter = mainAdapter

    }

    // text entered sent to new view
    fun sendMessage(view: View) {
        val editText =findViewById<EditText>(R.id.editTextTextPersonName)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    // go to movie list view
    fun movieListView(view: View) {
        val button = findViewById<Button>(R.id.button)
        val message = button.text.toString() + " list"
        val intent = Intent(this, MovieListActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}
