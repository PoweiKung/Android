package com.example.deron.t3_HiltMVVM

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.deron.databinding.ActivityMvvmBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HiltMVVMActivity : AppCompatActivity() {

    lateinit var binding: ActivityMvvmBinding

    // Hilt 架構只需要這樣寫，ViewModel 就能夠綁定 Activity
    private val viewModel: HiltMVVMViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()

    }

    private fun init() {
        binding = ActivityMvvmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // bar
        setSupportActionBar(binding.bar.toolbar)
        supportActionBar?.title = "Hilt MVVM"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)  // 顯示箭頭
        binding.bar.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // 觀察 LiveData → 自動更新 UI
        viewModel.user.observe(this) { user ->
            binding.tv.text = user
        }

        binding.btn.setOnClickListener {
            viewModel.uploadData()
        }

    }

}