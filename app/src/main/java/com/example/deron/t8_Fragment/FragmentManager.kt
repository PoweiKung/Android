package com.example.deron.t8_Fragment

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

object FragmentManager {

    fun FragmentActivity.startFragment(layoutId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(layoutId, fragment)
            .addToBackStack(fragment.javaClass.name)
            .commit()
    }

    fun FragmentActivity.backToFragment(fragment: Fragment) {
        supportFragmentManager.popBackStack(fragment.javaClass.name, 0)
    }

}