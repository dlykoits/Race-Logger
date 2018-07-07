package com.gmail.dlykoits.racelogger.services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import timber.log.Timber

class TrackingService : Service() {
    override fun onBind(p0: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    enum class State {
        NONE, PREPARING, READY
    }

    companion object {
        const val ACTION_START = ".start"
        const val ACTION_STOP = ".stop"
        fun sendStart(context: Context) {
            val intent = Intent(context, TrackingService.javaClass)
            intent.action = ACTION_START
            context.startService(intent)
        }

        fun sendStop(context: Context) {
            val intent = Intent(context, TrackingService.javaClass)
            intent.action = ACTION_STOP
            context.startService(intent)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.action
        Timber.d(action)
        when (action) {
            ACTION_START -> startSession()
            ACTION_STOP -> stopSession()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun startSession() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun stopSession() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}