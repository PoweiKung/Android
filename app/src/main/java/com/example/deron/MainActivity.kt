package com.example.deron

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deron.databinding.ActivityMainBinding
import com.example.deron.model.MainListModel
import com.example.deron.t1_MVP.MVPActivity
import com.example.deron.t2_MVVM.MVVMActivity
import com.example.deron.t3_HiltMVVM.HiltMVVMActivity
import com.example.deron.t4_Hilt.HiltActivity
import com.example.deron.t7_Retrofit.RetrofitActivity
import com.example.deron.t5_Room.RoomActivity
import com.example.deron.t6_Coroutine.CoroutineActivity
import com.example.deron.t8_Fragment.MyFragmentActivity

class MainActivity : AppCompatActivity(), MainAdapter.Listener {

    private lateinit var binding: ActivityMainBinding
    private val list = mutableListOf(
        MainListModel(name = "MVP", MVPActivity::class.java),
        MainListModel(name = "MVVM", MVVMActivity::class.java),
        MainListModel(name = "Hilt MVVM", HiltMVVMActivity::class.java),
        MainListModel(name = "Hilt", HiltActivity::class.java),
        MainListModel(name = "Retrofit", RetrofitActivity::class.java),
        MainListModel(name = "Room", RoomActivity::class.java),
        MainListModel(name = "Coroutine", CoroutineActivity::class.java),
        MainListModel(name = "Fragment", MyFragmentActivity::class.java)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // bar
        setSupportActionBar(binding.bar.toolbar)
        supportActionBar?.title = "首頁"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)  // 顯示箭頭
        binding.bar.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }


        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = MainAdapter(list, this)

    }

    override fun goToNextPage(pageClass: Class<*>?) {
        val intent = Intent(this, pageClass)
        startActivity(intent)
    }

    override fun showErrorMsg(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}