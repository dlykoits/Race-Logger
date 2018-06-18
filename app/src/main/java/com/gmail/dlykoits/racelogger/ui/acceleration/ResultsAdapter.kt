package com.gmail.dlykoits.racelogger.ui.acceleration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gmail.dlykoits.racelogger.R
import kotlinx.android.synthetic.main.result_item.view.*

class ResultsAdapter(private var resultsList: List<Pair<String, String>>) : RecyclerView.Adapter<ResultsAdapter.ResultItemHolder>() {

    class ResultItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.result_name
        val value: TextView = itemView.result_value
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultItemHolder {
        return ResultItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.result_item, parent, false))
    }

    override fun getItemCount() = resultsList.size

    override fun onBindViewHolder(holder: ResultItemHolder, position: Int) {
        val result = resultsList[position]
        holder.name.text = result.first
        holder.value.text = result.second
    }


    fun update(resultsList: List<Pair<String, String>>?){
        if(resultsList != null) {
            this.resultsList = resultsList
            notifyDataSetChanged()
        }
    }

}