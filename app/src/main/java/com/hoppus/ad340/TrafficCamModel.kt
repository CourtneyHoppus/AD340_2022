package com.hoppus.ad340

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

data class TrafficCamModel(val description: String,
                           val image: String,
                           val type: String,
                           val coordinates: Array<Double>) {

    private val baseURL: Map<String, String> = mapOf(
        "sdot" to "http://www.seattle.gov/trafficcams/images/",
        "wsdot" to "http://images.wsdot.wa.gov/nw/"
    )

    fun imageUrl() : String {
        return baseURL[this.type] + this.image
    }

    companion object {
        fun loadData(context: Context, updatedCameras: (ArrayList<TrafficCamModel>) -> Unit) {
            val dataURL = "https://web6.seattle.gov/Travelers/api/Map/Data?zoomId=13&type=2"
            val queue = Volley.newRequestQueue(context)
            val cameraList: ArrayList<TrafficCamModel> = ArrayList()

            val jsonObjReq = JsonObjectRequest( Request.Method.GET, dataURL, null,
                { response ->
                    try {
                        val features = response.getJSONArray("Features")
                        for (idx in 0 until features.length()) {
                            val point = features.getJSONObject(idx)
                            val pointCoordinates = point.getJSONArray("PointCoordinate")

                            val camera = point.getJSONArray("Cameras").getJSONObject(0)
                            val currentCamera = TrafficCamModel(
                                camera.getString("Description"),
                                camera.getString("ImageUrl"),
                                camera.getString("Type"),
                                arrayOf(
                                    pointCoordinates.getDouble(0),
                                    pointCoordinates.getDouble(1))
                            )
                            cameraList.add(currentCamera)
                        }
                        updatedCameras(cameraList)
                    } catch (e: JSONException) {
                        Log.d("JSON", "JSON Exception: %s".format(e.toString()))
                    }
                })
            { error -> Log.d("JSON", "Volley Error: %s".format(error.toString())) }
            queue.add(jsonObjReq)
        }
    }
}
