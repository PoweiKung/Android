package com.example.deron.t7_Retrofit

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.deron.databinding.ActivityRetrofitBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RetrofitActivity : AppCompatActivity() {

    lateinit var binding: ActivityRetrofitBinding
    private val viewModel: RetrofitViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()

    }

    fun init() {
        binding = ActivityRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // bar
        setSupportActionBar(binding.bar.toolbar)
        supportActionBar?.title = "Retrofit"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)  // 顯示箭頭
        binding.bar.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btn.setOnClickListener {
            viewModel.getUser()
        }

        viewModel.user.observe(this) { user ->
            binding.tv.text = user.name
        }

    }
}