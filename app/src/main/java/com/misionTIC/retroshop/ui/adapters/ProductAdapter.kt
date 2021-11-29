package com.misionTIC.retroshop.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.misionTIC.retroshop.OnProductListener
import com.misionTIC.retroshop.databinding.ItemProductBinding

class ProductAdapter(var items: List<Product>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(val item: ItemProductBinding): RecyclerView.ViewHolder(item.root)

    var listener: OnProductListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.item.itemProductName.text = item.name
        holder.item.itemProductPrice.text = item.price
        Glide.with(holder.itemView).load(item.image).into(holder.item.itemProductPhoto)
        holder.item.root.setOnClickListener {
            listener?.onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun newDataSet(newData: List<Product>){
        items = newData
        notifyDataSetChanged()
    }
}