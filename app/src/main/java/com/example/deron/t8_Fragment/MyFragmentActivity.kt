package com.example.deron.t8_Fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.deron.databinding.ActivityFragmentBinding
import com.example.deron.t8_Fragment.FragmentManager.startFragment
import androidx.activity.addCallback
import androidx.activity.viewModels

class MyFragmentActivity : AppCompatActivity() {

    lateinit var binding: ActivityFragmentBinding

    private val viewModel: MyFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
        backPressed()
        this.startFragment(binding.container.id, MyFragmentOne.newInstance())

    }

    private fun init() {
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // bar
        setSupportActionBar(binding.bar.toolbar)
        supportActionBar?.title = "Fragment"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)  // 顯示箭頭
        binding.bar.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    fun goToFragmentTwo() {
        this.startFragment(binding.container.id, MyFragmentTwo.newInstance())
    }

    private fun backPressed() {
        onBackPressedDispatcher.addCallback(this) {
            if (supportFragmentManager.backStackEntryCount <= 1) {
                finish()
            } else {
                supportFragmentManager.popBackStack()
            }
        }
    }
}
