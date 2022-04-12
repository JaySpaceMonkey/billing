package com.example.billing.Model

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.billing.Data.ProductItem
import com.example.billing.databinding.CardInContentsBinding

class ProductItemAdapter : RecyclerView.Adapter<ProductItemAdapter.ProductItemViewHolder>(),
    Filterable {

    private lateinit var listener: (ProductItem) -> Unit
    private lateinit var addListener: (Button) -> Unit
    var productList = ArrayList<ProductItem>()
    var contentsFilterList = productList


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
        val pos= holder.bindingAdapterPosition
        holder.bindView(contentsFilterList[position])
        holder.itemView.setOnClickListener {
            listener(contentsFilterList[position])

        }


    }

    override fun getItemCount(): Int {

        return contentsFilterList.size
    }

    fun setData(productList: ArrayList<ProductItem>) {
        this.contentsFilterList.clear()
        this.contentsFilterList.addAll(productList)
        notifyDataSetChanged()


    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val filterResults = FilterResults()

                if (charSequence == null || charSequence.isEmpty()) {
                    filterResults.count = productList.size
                    filterResults.values = productList
                } else {
                    val searchChar = charSequence.toString().lowercase()
                    val resultList = mutableListOf<ProductItem>()
                    for (items in contentsFilterList) {
                        if (items.titleProduct.lowercase().contains(searchChar)) {
                            resultList.add(items)
                        }
                    }
                    filterResults.count = resultList.size
                    filterResults.values = resultList


                }
                return filterResults

            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                contentsFilterList = p1?.values as ArrayList<ProductItem>
                notifyDataSetChanged()

            }

        }


    }


    inner class ProductItemViewHolder(
        val binding: CardInContentsBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {


        fun bindView(contentList: ProductItem) {
            val pos=bindingAdapterPosition
            itemView.apply {
                binding.productName.setText(contentList.titleProduct)
                binding.MRP.setText(contentList.mrpProduct.toString())
                binding.GST.setText(contentList.gstProduct.toString())
                binding.addbutton.setOnClickListener {
                    addListener(binding.addbutton)
                }
            }
        }

    }

    fun setClick(function: (ProductItem) -> Unit) {
        this.listener = function
    }

    fun setBtnClick(function: (Button) -> Unit) {
        this.addListener = function
    }


}

