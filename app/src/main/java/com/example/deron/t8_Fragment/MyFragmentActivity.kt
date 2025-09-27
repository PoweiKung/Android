package com.example.deron.t8_Fragment

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.deron.databinding.ActivityFragmentBinding

class MyFragmentActivity : AppCompatActivity() {

    lateinit var binding: ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()

    }

    private fun init() {
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContent { binding.root }

        // bar
        setSupportActionBar(binding.bar.toolbar)
        supportActionBar?.title = "Fragment"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)  // 顯示箭頭
        binding.bar.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

}
