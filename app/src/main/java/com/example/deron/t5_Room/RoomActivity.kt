package com.example.deron.t5_Room

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deron.databinding.ActivityRoomBinding
import com.example.deron.t5_Room.table.RoomUser
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class RoomActivity : AppCompatActivity() {

    lateinit var binding: ActivityRoomBinding
    private val viewModel: RoomViewModel by viewModels()

    private val adapter = RoomAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    fun init() {
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // bar
        setSupportActionBar(binding.bar.toolbar)
        supportActionBar?.title = "Room"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)  // 顯示箭頭
        binding.bar.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = adapter

        viewModel.userList.observe(this) { users ->
            adapter.updateData(users)
        }

        binding.btnInsert.setOnClickListener {
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString()
            if (name.isNotEmpty() && age.isNotEmpty()) {
                val user = RoomUser(name = name, age = age.toInt())
                viewModel.insertUser(user)
            }
        }
    }
}