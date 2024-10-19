package com.example.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    private val languages: List<Language>,
    private val myListener: (Language) -> Unit
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_language, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languages.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current: Language = languages[position]
        holder.bind(current, myListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val languageName: TextView = itemView.findViewById(R.id.tv_language)
        private val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.cl_constraint)

        fun bind(language: Language, myListener: (Language) -> Unit) {
            languageName.text = language.name
            constraintLayout.setOnClickListener {
                myListener(language)
            }
        }
    }
}
