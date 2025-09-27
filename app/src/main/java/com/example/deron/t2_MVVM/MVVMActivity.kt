package com.example.deron.t2_MVVM

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.deron.databinding.ActivityMvvmBinding

class MVVMActivity : AppCompatActivity() {

    lateinit var binding: ActivityMvvmBinding
    lateinit var viewModel: MVVMViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()

    }

    private fun init() {
        binding = ActivityMvvmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // bar
        setSupportActionBar(binding.bar.toolbar)
        supportActionBar?.title = "MVVM"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)  // 顯示箭頭
        binding.bar.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // 基本寫法一
        // viewModel = MVVMViewModel()

        // 寫法二(工廠模式)
        val repository = MVVMRepository()
        val factory = MVVMFactory(repository)
        // viewModel = ViewModelProvider(this, factory).get(MVVMViewModel::class.java)
        viewModel = ViewModelProvider(this, factory)[MVVMViewModel::class.java] // 也可以這樣寫

        // 觀察 LiveData → 自動更新 UI
        viewModel.user.observe(this) { user ->
            binding.tv.text = user
        }


        binding.btn.setOnClickListener {
            viewModel.uploadData()
        }

    }

}