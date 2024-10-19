package com.example.myapplication.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.model.Product

class AllProductAdapter : RecyclerView.Adapter<AllProductAdapter.ProductViewHolder>() {

    private var products: List<Product> = listOf()
    private var onFavoriteClickListener: ((Product) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_layout, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)

        holder.btnAddToFav.setOnClickListener {
            onFavoriteClickListener?.invoke(product)
        }
    }

    override fun getItemCount(): Int = products.size

    fun setProducts(productList: List<Product>) {
        this.products = productList
        notifyDataSetChanged()
    }

    fun setOnFavoriteClickListener(listener: (Product) -> Unit) {
        this.onFavoriteClickListener = listener
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewTitle: TextView = itemView.findViewById(R.id.editTitle)
        private val textViewPrice: TextView = itemView.findViewById(R.id.editPrice)
        private val textViewBrand: TextView = itemView.findViewById(R.id.editBrand)
        private val textViewDescription: TextView = itemView.findViewById(R.id.editDescription)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView) // Updated ImageView reference
        val btnAddToFav: Button = itemView.findViewById(R.id.btndeleteToFav)

        fun bind(product: Product) {
            textViewTitle.text = product.title
            textViewPrice.text = product.price.toString()
            //textViewBrand.text = product. // Assuming Product has a brand property
            textViewDescription.text = product.description

            // Load image using Glide
            Glide.with(itemView.context)
                .load(product.imageUrl) // Assuming Product has an imageUrl property
                .into(imageView)
        }
    }
}
