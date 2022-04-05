package com.example.billing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.example.billing.Model.ProductItem
import com.example.billing.databinding.ActivityContentsBinding

class ContentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContentsBinding
    private val adapter: ProductItemAdapter by lazy {
        ProductItemAdapter()
    }
    val contentList: MutableList<ProductItem> by lazy {
        mutableListOf(
            ProductItem("Dolo", 20.0, 2.0),
            ProductItem("citrizen", 10.0, 2.0),
            ProductItem("cough syrup", 57.0, 3.80),
            ProductItem("saradon", 3.0, 0.30)
        )
    }
    val displayList=contentList as ArrayList<ProductItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this, VERTICAL, false)
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.adapter = adapter
        adapter.setData(displayList)

    }
}