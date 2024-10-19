package com.example.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MyDiffUtil : DiffUtil.ItemCallback<Language>(){
    override fun areItemsTheSame(oldItem: Language, newItem: Language): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Language, newItem: Language): Boolean {
        return oldItem == newItem
    }

}

class ListAdapterDemo(private val myListener: (Language) -> Unit) : ListAdapter<Language ,ListAdapterDemo.ViewHolder>(MyDiffUtil()){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val languageName: TextView = itemView.findViewById(R.id.tv_language)
        val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.cl_constraint)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater : LayoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_language,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentlanguage = getItem(position)
        holder.languageName.text = currentlanguage.name
        holder.constraintLayout.setOnClickListener {
            myListener(currentlanguage)
        }

    }
}