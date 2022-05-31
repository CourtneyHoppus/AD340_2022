package com.hoppus.ad340

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class Utilities {
    companion object {
        fun isConnected(context: Context): Boolean {
            val isConnected : Boolean
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                    as ConnectivityManager
            val activeNetwork = connectivityManager.activeNetwork
            val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
            if (activeNetwork == null || networkCapabilities == null) return false
            isConnected = when {
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
            return isConnected
        }
    }
}
