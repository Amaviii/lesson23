package com.example.lesson23

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson23.presentation.MyAdapter
import com.example.lesson23.databinding.ActivityMainBinding
import com.example.lesson23.presentation.CountViewModel

class MainActivity : AppCompatActivity() {

    private val countViewModel: CountViewModel by viewModels()
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding?.root)
        setupView()

    }

    fun setupView() {

        val adapter = MyAdapter(mutableListOf())
        binding?.recyclerView?.layoutManager = LinearLayoutManager(this)
        binding?.recyclerView?.adapter = adapter

        countViewModel.count.observe(this, { filteredList ->
            adapter.updateList(filteredList)
        })

        binding?.button?.setOnClickListener {
            val filterText = binding?.editText?.text.toString()
            countViewModel.touchButton(filterText)
        }
    }
}