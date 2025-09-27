package com.example.deron.t6_Coroutine

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.deron.databinding.ActivityCoroutineBinding

class CoroutineActivity : AppCompatActivity() {

    lateinit var binding: ActivityCoroutineBinding
    private val viewModel: CoroutineViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
        viewModelObserve()
        viewModel.startStopWatch()
    }

    private fun init() {
        binding = ActivityCoroutineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // bar
        setSupportActionBar(binding.bar.toolbar)
        supportActionBar?.title = "Coroutine"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)  // 顯示箭頭
        binding.bar.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btn.setOnClickListener {
            val userName = binding.et.text.toString()
            viewModel.getUser(userName)
        }
    }

    private fun viewModelObserve() {
        viewModel.apply {
            user.observe(this@CoroutineActivity) { user -> binding.tv.text = user.name }
            time.observe(this@CoroutineActivity) { time -> binding.tvTime.text = time }
            toast.observe(this@CoroutineActivity) { msg -> showToastMsg(msg) }
        }
    }

    private fun showToastMsg(msg: String) {
        Toast.makeText(this@CoroutineActivity, msg, Toast.LENGTH_SHORT).show()
    }


}