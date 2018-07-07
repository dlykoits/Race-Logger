package com.gmail.dlykoits.racelogger.ui.acceleration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail.dlykoits.racelogger.R
import com.gmail.dlykoits.racelogger.services.TrackingService
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AccelerationFragment : Fragment() {

    companion object {
        fun newInstance() = AccelerationFragment()
    }

    private lateinit var paramsView: RecyclerView
    private lateinit var paramsAdapter: ParamsAdapter
    private lateinit var actionButton: FloatingActionButton
    private lateinit var resultsView: RecyclerView
    private lateinit var resultsAdapter: ResultsAdapter
    private lateinit var viewModel: AccelerationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        paramsView = view.findViewById(R.id.current_params)
        resultsView = view.findViewById(R.id.results_view)
        actionButton = view.findViewById(R.id.action_button)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(AccelerationViewModel::class.java)

        paramsView.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        paramsAdapter = ParamsAdapter(ArrayList())
        paramsView.adapter = paramsAdapter

        viewModel.params.observe(this, Observer {
            paramsAdapter.update(it)
        })


        resultsView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        resultsAdapter = ResultsAdapter(ArrayList())
        resultsView.adapter = resultsAdapter

        viewModel.results.observe(this, Observer {
            resultsAdapter.update(it)
        })

        viewModel.state.observe(this, Observer {
            var imgRes = android.R.drawable.ic_media_play
            when (it) {
                TrackingService.State.NONE -> imgRes = android.R.drawable.ic_media_play
                TrackingService.State.PREPARING -> imgRes = android.R.drawable.ic_lock_idle_lock
                TrackingService.State.READY -> imgRes = android.R.drawable.ic_media_pause
            }
            actionButton.setImageResource(imgRes)
        })

        actionButton.setOnClickListener { _ -> viewModel.actionPressed()}
    }
}
