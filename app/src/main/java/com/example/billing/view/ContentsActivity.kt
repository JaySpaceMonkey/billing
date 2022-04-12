package com.example.billing

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.example.billing.Data.CartItem
import com.example.billing.Data.ProductItem
import com.example.billing.Model.CartItemAdapter
import com.example.billing.Model.ProductItemAdapter
import com.example.billing.databinding.ActivityContentsBinding
import com.example.billing.databinding.BottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class ContentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContentsBinding
    private lateinit var btmbinding: BottomSheetBinding
    private val adapter: ProductItemAdapter by lazy {
        ProductItemAdapter()
    }
    private val adapter2: CartItemAdapter by lazy {
        CartItemAdapter()
    }
    val contentList: MutableList<ProductItem> by lazy {
        mutableListOf(
            ProductItem("Dolo", 20.0, 2.0),
            ProductItem("citrizen", 10.0, 2.0),
            ProductItem("cough syrup", 57.0, 3.80),
            ProductItem("saradon", 3.0, 0.30)
        )
    }
    val displayList = contentList as ArrayList<ProductItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this, VERTICAL, false)
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.adapter = adapter
        adapter.setData(displayList)

        adapter.setClick {
            Toast.makeText(this, "yes its working ", Toast.LENGTH_SHORT).show()

        }

        adapter.setBtnClick {
            val ad = CartItemAdapter()
            ad.cartList.add(CartItem("med1",20.toDouble(),4.toDouble(),"23dree"))
          //  binding.recyclerview.swapAdapter(adapter2, true)




            val btnsheet = layoutInflater.inflate(R.layout.bottom_sheet, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(btnsheet)
            btnsheet.setOnClickListener {

               // dialog.dismiss()
            }
            btmbinding = BottomSheetBinding.inflate(layoutInflater)
            btmbinding.proceedbtn.setOnClickListener {

                Toast.makeText(this, "wokring", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, cartActivity::class.java))

            }
            dialog.show()

            Toast.makeText(this, "its button", Toast.LENGTH_SHORT).show()

        }
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true

            }

        })


    }
}