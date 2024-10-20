package com.example.myapplication.favorite.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Product

class FavAdapter(private val deleteCallback: (Product) -> Unit) :
    ListAdapter<Product, FavAdapter.FavViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fav_recycle_layout, parent, false)
        return FavViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        holder.bind(getItem(position), deleteCallback)
    }

    class FavViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewTitle: TextView = itemView.findViewById(R.id.editTitle)
        private val textViewPrice: TextView = itemView.findViewById(R.id.editPrice)
        private val textViewBrand: TextView = itemView.findViewById(R.id.editBrand)
        private val textViewDescription: TextView = itemView.findViewById(R.id.editDescription)

        private val deleteButton: TextView = itemView.findViewById(R.id.btndeletefromFav)

        fun bind(product: Product, deleteCallback: (Product) -> Unit) {
            textViewTitle.text = product.title
            textViewPrice.text = product.price.toString()
            //textViewBrand.text = product.
            textViewDescription.text = product.description
            deleteButton.setOnClickListener {
                deleteCallback(product) // Call delete on click
            }
        }
    }

    class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}
