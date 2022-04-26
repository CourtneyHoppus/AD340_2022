package com.hoppus.ad340

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.Toast

internal class MainAdapter(
    private val context: Context,
    private val textForItems: Array<String>
) : BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var button: Button

    override fun getCount(): Int {
        return textForItems.size
    }
    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.grid_items, null)
        }
        button = convertView!!.findViewById(R.id.gridButton)
        button.text = textForItems[position]
        button.setOnClickListener {
            Toast.makeText(context, "You clicked " + textForItems[position], Toast.LENGTH_SHORT).show()
        }
        return convertView
    }
}
