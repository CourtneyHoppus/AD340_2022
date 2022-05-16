package com.hoppus.ad340

data class TrafficCamModel(val description: String,
                           val imageURL: String,
                           val urlType: String) {

    private val baseURL: Map<String, String> = mapOf(
        "sdot" to "http://www.seattle.gov/trafficcams/images/",
        "wsdot" to "http://images.wsdot.wa.gov/nw/"
    )

    fun imageURL() : String {
        return baseURL[this.urlType] + this.imageURL
    }


}
