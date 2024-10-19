package com.example.a03_session

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MystartedService : Service() {

    private val TAG = "services"

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "Service onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "Service onStartCommand")
        // Return START_STICKY if you want the service to be restarted if killed by the system
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        // This service doesn't support binding, so return null
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Service onDestroy")
    }
}
