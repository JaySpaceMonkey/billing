package com.example.billing.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.billing.CartItemAdapter
import com.example.billing.Model.CartItem
import com.example.billing.databinding.ActivityCartBinding

class cartActivity : AppCompatActivity() {
    private val adapter : CartItemAdapter by lazy{
        CartItemAdapter()

    }
    private lateinit var binding:ActivityCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)


        adapter.cartList.add(CartItem("Product name",20.0,4.0,"12sdc3"))

        adapter.setData(adapter.cartList)


    }
}