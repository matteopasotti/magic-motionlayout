package com.matteopasotti.magicmotion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.matteopasotti.magicmotion.ExampleActivity
import com.matteopasotti.magicmotion.MainActivity
import com.matteopasotti.magicmotion.R

class ExampleAdapter (private val dataset: Array<ExampleAdapter.Example>) :
    RecyclerView.Adapter<ExampleAdapter.ViewHolder>() {

    data class Example(val title: String, val layout : Int = 0, val activity : Class<*> = ExampleActivity::class.java) {
        constructor(title: String, activity : Class<*> = ExampleActivity::class.java) : this(title, 0, activity)
    }

    class ViewHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout) {
        var button = layout.findViewById(R.id.button) as Button
        var layoutFileId = 0
        var activity : Class<*>? = null

        init {
            button.setOnClickListener {
                val context = it?.context as MainActivity
                activity?.let {
                    context.start(it, layoutFileId)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ExampleAdapter.ViewHolder {
        val row = LayoutInflater.from(parent.context)
            .inflate(R.layout.row, parent, false) as ConstraintLayout
        return ViewHolder(row)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.button.text = dataset[position].title
        holder.layoutFileId = dataset[position].layout
        holder.activity = dataset[position].activity
    }

    override fun getItemCount() = dataset.size
}