package com.noma.livestockcare.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.noma.livestockcare.R
import com.noma.livestockcare.model.Product

class ProductsAdapter() :RecyclerView.Adapter<ProductsAdapter.ActivityViewHolder>() {

    private var products: List<Product> = emptyList()

    fun setProducts(newProducts: ArrayList<Product>){
        products = newProducts
        notifyDataSetChanged()
    }

    class ActivityViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val product_name = itemView.findViewById<TextView>(R.id.product_name)
        val product_description = itemView.findViewById<TextView>(R.id.product_description)
        val product_quantity = itemView.findViewById<TextView>(R.id.product_quantity)
        val product_price = itemView.findViewById<TextView>(R.id.product_price_value)
        val product_image = itemView.findViewById<ImageView>(R.id.product_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, null,false)
        return ActivityViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  products.size
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val product = products[position]
        holder.product_name.text = product.product
        holder.product_description.text = product.description
        holder.product_quantity.text = "Qty: " + product.quantity
        holder.product_price.text =  product.price
        holder.product_image.setImageResource(R.drawable.product)
    }
}