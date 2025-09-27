package com.example.deron.t4_Hilt

import android.util.Log
import android.widget.Toast
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Named


object SingletonGeneral {
    fun getData(): HiltData {
        return HiltData(name = "Deron")
    }
}


/**
 *  Hilt Singleton Component
 *  這告訴 Hilt：Singleton 要一個 HiltData，請幫我去找。
 */
class Singleton @Inject constructor(@Named("B") val data: HiltData) {
    fun show() {
        Log.v("Singleton", data.name)
    }
}

/**
 *  如果不能自己 New 的物件，像是第三方包 Retrofit 的 Class 沒辦法補 Inject，就必須使用 Module + Provides
 */
@Module // 標記 Module
@InstallIn(SingletonComponent::class) // 這個 Module 要安裝到 Hilt 的哪個 Component
object SingletonHilt {
    @Provides
    @Named("A")
    fun getDataA(): HiltData {
        return HiltData(name = "This is Singleton A")
    }

    @Provides
    @Named("B")
    fun getDataB(): HiltData {
        return HiltData(name = "This is Singleton B")
    }
}