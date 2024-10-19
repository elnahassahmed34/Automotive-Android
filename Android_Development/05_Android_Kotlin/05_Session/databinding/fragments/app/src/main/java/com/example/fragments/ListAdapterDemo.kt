package com.example.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.databinding.ItemLanguageBinding // Import the generated binding class

class MyDiffUtil : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}

class ListAdapterDemo(private val myListener: (Product) -> Unit) : ListAdapter<Product, ListAdapterDemo.ViewHolder>(MyDiffUtil()) {

    class ViewHolder(private val binding: ItemLanguageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product, myListener: (Product) -> Unit) {
            binding.product = product // Set the product for data binding
            binding.executePendingBindings() // Execute pending bindings to update the UI
            binding.clConstraint.setOnClickListener { myListener(product) } // Set the click listener
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemLanguageBinding = DataBindingUtil.inflate(inflater, R.layout.item_language, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProduct = getItem(position)
        holder.bind(currentProduct, myListener)
    }
}
