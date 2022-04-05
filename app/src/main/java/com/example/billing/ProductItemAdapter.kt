package com.example.billing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.billing.Model.ProductItem
import com.example.billing.databinding.CardInContentsBinding

class ProductItemAdapter : RecyclerView.Adapter<ProductItemAdapter.ProductItemViewHolder>() {


    var productList = ArrayList<ProductItem>()
    val contentsFilterList = productList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        return ProductItemViewHolder(
            CardInContentsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(
        holder: ProductItemViewHolder,
        position: Int
    ) {
        holder.bindView(contentsFilterList[position])
    }

    override fun getItemCount(): Int {

        return contentsFilterList.size
    }

    fun setData(productList: ArrayList<ProductItem>) {
        this.productList.clear()
        this.productList.addAll(productList)
        notifyDataSetChanged()


    }

    inner class ProductItemViewHolder(
        private val binding: CardInContentsBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(contentList: ProductItem) {
            itemView.apply {
                binding.productName.setText(contentList.titleProduct)
                binding.MRP.setText(contentList.mrpProduct.toString())
                binding.GST.setText(contentList.gstProduct.toString())


            }
        }

    }


}

