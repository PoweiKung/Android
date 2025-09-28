package com.example.deron.t9_DialogFragment

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.deron.databinding.ActivityDialogFragmentBinding

class DialogFragmentActivity : AppCompatActivity() {

    lateinit var binding: ActivityDialogFragmentBinding

    private val viewModel: DialogFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
        viewModelObserve()
    }

    private fun init() {
        binding = ActivityDialogFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // bar
        setSupportActionBar(binding.bar.toolbar)
        supportActionBar?.title = "Dialog Fragment"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)  // 顯示箭頭
        binding.bar.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btn.setOnClickListener {
            MyDialogFragment.newInstance()
                .show(supportFragmentManager, MyDialogFragment.javaClass.name)
        }
    }

    private fun viewModelObserve() {

    }
}