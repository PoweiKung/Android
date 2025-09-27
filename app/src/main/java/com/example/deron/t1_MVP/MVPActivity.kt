package com.example.deron.t1_MVP

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.deron.databinding.ActivityMvpBinding

class MVPActivity : AppCompatActivity(), MVPContract.View {

    private lateinit var binding: ActivityMvpBinding
    private lateinit var presenter: MVPContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()

    }
    private fun init() {
        binding = ActivityMvpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // bar
        setSupportActionBar(binding.bar.toolbar)
        supportActionBar?.title = "MVP"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)  // 顯示箭頭
        binding.bar.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        presenter = MVPPresenter(this)

        binding.btn.setOnClickListener {
            presenter.loadData()
        }
    }

    override fun showMessage(message: String) {
        binding.tv.text = message
    }
}

