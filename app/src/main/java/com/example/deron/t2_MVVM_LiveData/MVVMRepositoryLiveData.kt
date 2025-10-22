package com.example.deron.t2_MVVM_LiveData

import kotlinx.coroutines.delay

class MVVMRepositoryLiveData {

    suspend fun getDataFromServer(): String {
        delay(2000)
        return "Server Data"
    }
}