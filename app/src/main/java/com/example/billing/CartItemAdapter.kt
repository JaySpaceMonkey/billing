package com.example.billing.Model

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.billing.Data.CartItem
import com.example.billing.databinding.CardInCartBinding


class CartItemAdapter : RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder>() {

    val cartList= ArrayList<CartItem>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {

        return CartItemViewHolder(
            CardInCartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun getPos(holder: CartItemViewHolder):Int{
        return holder.absoluteAdapterPosition
    }



    override fun getItemCount(): Int {
        return cartList.size

    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        holder.bindView(cartList[position])

    }
    fun setData(cartList:ArrayList<CartItem>){
        this.cartList.clear()
        this.cartList.addAll(cartList)
        notifyDataSetChanged()

    }

    inner class CartItemViewHolder(
        private val binding: CardInCartBinding
    ):RecyclerView.ViewHolder(binding.root) {
        fun bindView(cartItem: CartItem){
            itemView.apply{
                binding.productName.setText(cartItem.productName)
                binding.MRP.setText(cartItem.mrp.toString())
                binding.GST.setText(cartItem.gst.toString())
                binding.batchNumber.setText(cartItem.batchNO)


            }


        }

    }
}