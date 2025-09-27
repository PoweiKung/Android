package com.example.deron

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application(){

//    val database by lazy { DB.getDataBase(this) }
//    val repository by lazy { UserRepository(database.userDao()) }

}