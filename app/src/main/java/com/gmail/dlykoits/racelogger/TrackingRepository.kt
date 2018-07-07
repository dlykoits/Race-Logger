package com.gmail.dlykoits.racelogger

import android.content.Context
import com.gmail.dlykoits.racelogger.services.TrackingService

class TrackingRepository(val context: Context) {

    interface ParamsListener {
        fun onParamChanged()
    }

    interface ResultListener {
        fun onResultChanged()
    }

    interface StateListener {
        fun onStateChanged(state: TrackingService.State)
    }

    var paramsListener: ParamsListener? = null
    var resultListener: ResultListener? = null
    var stateListener: StateListener? = null

    fun start() {
        stateListener?.onStateChanged(TrackingService.State.READY)
//        TrackingService.sendStart(context)
    }

    fun stop() {
        stateListener?.onStateChanged(TrackingService.State.NONE)
//        TrackingService.sendStop(context)
    }
}