package com.example.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.databinding.ItemLanguageBinding // Import your generated binding class

class MyDiffUtil : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}

class ListAdapterDemo(private val myListener: (Product) -> Unit) : ListAdapter<Product, ListAdapterDemo.ViewHolder>(MyDiffUtil()) {

    // Use View Binding
    inner class ViewHolder(private val binding: ItemLanguageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.tvTitle.text = product.title
            binding.tvPrice.text = product.price.toString()

            binding.clConstraint.setOnClickListener {
                myListener(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the layout using View Binding
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLanguageBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProduct = getItem(position)
        holder.bind(currentProduct) // Bind data to ViewHolder
    }
}
