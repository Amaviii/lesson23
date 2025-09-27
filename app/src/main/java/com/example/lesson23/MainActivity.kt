package com.example.lesson23

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val countViewModel: CountViewModel by viewModels()
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding?.root)

        countViewModel.count.observe(this, { count ->
            binding?.counterTv?.text = count.toString()
        })

        binding?.counterBtn?.setOnClickListener {
            countViewModel.touchButton()
        }

    }
}