package com.hoppus.ad340

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class TrafficCamAdapter(
    private val cameraList: List<TrafficCamModel>
) : RecyclerView.Adapter<TrafficCamAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.traffic_cam_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val camera = cameraList[position]
        holder.textView.text = camera.description
        val imageURL = camera.imageURL()
        Picasso.get().load(imageURL).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return cameraList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}