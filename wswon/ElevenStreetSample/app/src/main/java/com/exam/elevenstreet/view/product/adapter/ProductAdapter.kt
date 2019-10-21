package com.exam.elevenstreet.view.product.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exam.elevenstreet.view.product.adapter.viewholder.ProductViewHolder
import com.exam.elevenstreet.data.model.ProductItem

class ProductAdapter : RecyclerView.Adapter<ProductViewHolder>() {

    private var productItemList = mutableListOf<ProductItem>()

    private var onClickListener: OnClickListener? = null

    interface OnClickListener{
        fun onClick(productItem: ProductItem)
    }

    fun setOnClickListener(listener: OnClickListener){
        onClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(parent)

    override fun getItemCount(): Int =
        productItemList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(productItemList[position], onClickListener)

    fun addData(productItem: ProductItem){
        productItemList.add(productItem)
        notifyItemInserted(productItemList.lastIndex)
    }
    fun clearListData(){
        productItemList.clear()
        notifyDataSetChanged()
    }
}