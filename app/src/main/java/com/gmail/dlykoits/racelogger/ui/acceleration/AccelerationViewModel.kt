package com.gmail.dlykoits.racelogger.ui.acceleration

import android.app.Application
import android.os.Handler
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gmail.dlykoits.racelogger.LoggerApplication
import com.gmail.dlykoits.racelogger.TrackingRepository
import com.gmail.dlykoits.racelogger.services.TrackingService
import java.util.*

class AccelerationViewModel(application: Application) : AndroidViewModel(application), TrackingRepository.ParamsListener,
        TrackingRepository.ResultListener, TrackingRepository.StateListener {
    private val _params = MutableLiveData<List<Pair<String, String>>>()
    private val _results = MutableLiveData<List<Pair<String, String>>>()
    private val _state = MutableLiveData<TrackingService.State>()

    private val trackingRepository = (application as LoggerApplication).trackingRepository

    val params: LiveData<List<Pair<String, String>>>
        get() = _params
    val results: LiveData<List<Pair<String, String>>>
        get() = _results
    val state: LiveData<TrackingService.State>
        get() = _state


    val handler = Handler()

    init {
        val paramsList = ArrayList<Pair<String, String>>()
        paramsList.add(Pair("Distance", "402.1 m"))
        paramsList.add(Pair("Duration", "11.2 s"))
        paramsList.add(Pair("Speed", "101.1"))
        paramsList.add(Pair("G-Load", "0.81"))
        _params.value = paramsList
        trackingRepository.paramsListener = this

        val resultsList = ArrayList<Pair<String, String>>()
        resultsList.add(Pair("Max speed", "105.1"))
        resultsList.add(Pair("Max g-load", "0.94"))
        resultsList.add(Pair("Acceleration 0-30", "2.0"))
        resultsList.add(Pair("Acceleration 0-60", "5.0"))
        resultsList.add(Pair("Acceleration 0-100", "8.0"))
        _results.value = resultsList
        trackingRepository.resultListener = this

        _state.value = TrackingService.State.NONE
        trackingRepository.stateListener = this
    }

    fun actionPressed() {
        _state.postValue(TrackingService.State.PREPARING)
        if(_state.value == TrackingService.State.NONE) {
            trackingRepository.start()
        } else {
            trackingRepository.stop()
        }
    }

    override fun onStateChanged(state: TrackingService.State) {
        handler.postDelayed(Runnable {
            _state.postValue(state)
        }, 500)
    }

    override fun onParamChanged() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResultChanged() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
