package com.amoronk.newsapp.utils

import android.content.Context
import android.net.ConnectivityManager

object NetworkUtil {

    fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting && netInfo.isAvailable && netInfo.isConnected
    }
}