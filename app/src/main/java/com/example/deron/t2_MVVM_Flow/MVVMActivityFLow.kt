package com.example.deron.t2_MVVM_Flow

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.deron.databinding.ActivityMvvmBinding
import kotlinx.coroutines.launch

class MVVMActivityFLow : AppCompatActivity() {

    lateinit var binding: ActivityMvvmBinding
    lateinit var viewModel: MVVMVIewModelFlow

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

        // (工廠模式)
        val repository = MVVMRepositoryFlow()
        val factory = MVVMFactoryFlow(repository)
        viewModel = ViewModelProvider(this, factory)[MVVMVIewModelFlow::class.java] // 也可以這樣寫

        // 觀察 Flow
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {


                /**
                 *  Type one ( flow directly )
                 *  俗稱 Cold Flow
                 *  每次都執行全部，跟 function 一樣
                 */
                launch {
                    repository.getDataFromServer().collect { data ->
                        Log.v("test", "冷流_Flow_${data}")
                    }
                }


                /**
                 *  Type two ( StateFlow )
                 *  俗稱 Hot Flow
                 *  會保存狀態，跟 LiveData 一樣的用法，但用 Flow 架構的話可以多次回傳
                 */
                launch {
                    viewModel.user.collect { data ->
                        Log.v("test", "熱流_StateFlow_${data}")
                        binding.tv.text = data
                    }
                }

                /**
                 *  Type two ( SharedFlow )
                 *  俗稱 Hot Flow
                 *  只執行一次，適合 Toast、跳轉畫面、多個元件同時接收廣播 ( 避免旋轉的時候重複執行 )
                 */
                launch {
                    viewModel.event.collect { message ->
                        Log.v("test", "熱流_SharedFlow_${message}")
                        Toast.makeText(this@MVVMActivityFLow, message, Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
        binding.btn.setOnClickListener {
            viewModel.uploadData()
            viewModel.uploadDataSharedFlow()
        }

    }
}