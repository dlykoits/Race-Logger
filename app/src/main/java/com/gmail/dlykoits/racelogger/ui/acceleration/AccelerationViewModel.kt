package com.gmail.dlykoits.racelogger.ui.acceleration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.ArrayList

class AccelerationViewModel : ViewModel() {

    private val _params = MutableLiveData<List<Pair<String, String>>>()
    private val _results = MutableLiveData<List<Pair<String, String>>>()

    val params: LiveData<List<Pair<String, String>>>
        get() = _params
    val results: LiveData<List<Pair<String, String>>>
        get() = _results

    init {
        val paramsList = ArrayList<Pair<String, String>>()
        paramsList.add(Pair("Distance", "402.1 m"))
        paramsList.add(Pair("Duration", "11.2 s"))
        paramsList.add(Pair("Speed", "101.1"))
        paramsList.add(Pair("G-Load", "0.81"))
        _params.value = paramsList

        val resultsList = ArrayList<Pair<String, String>>()
        resultsList.add(Pair("Max speed", "105.1"))
        resultsList.add(Pair("Max g-load", "0.94"))
        resultsList.add(Pair("Acceleration 0-30", "2.0"))
        resultsList.add(Pair("Acceleration 0-60", "5.0"))
        resultsList.add(Pair("Acceleration 0-100", "8.0"))
        _results.value = resultsList
    }

}
