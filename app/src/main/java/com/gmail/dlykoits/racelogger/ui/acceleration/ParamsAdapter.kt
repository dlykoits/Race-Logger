package com.gmail.dlykoits.racelogger.ui.acceleration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gmail.dlykoits.racelogger.R
import kotlinx.android.synthetic.main.param_item.view.*
import kotlinx.android.synthetic.main.result_item.view.*

class ParamsAdapter(private var resultsList: List<Pair<String, String>>) : RecyclerView.Adapter<ParamsAdapter.ParamItemHolder>() {

    class ParamItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label: TextView = itemView.label
        val param: TextView = itemView.param
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParamItemHolder {
        return ParamItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.param_item, parent, false))
    }

    override fun getItemCount() = resultsList.size

    override fun onBindViewHolder(holder: ParamItemHolder, position: Int) {
        val result = resultsList[position]
        holder.label.text = result.first
        holder.param.text = result.second
    }


    fun update(resultsList: List<Pair<String, String>>?){
        if(resultsList != null) {
            this.resultsList = resultsList
            notifyDataSetChanged()
        }
    }

}