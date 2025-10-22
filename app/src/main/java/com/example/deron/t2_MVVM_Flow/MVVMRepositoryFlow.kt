package com.example.deron.t2_MVVM_Flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MVVMRepositoryFlow {

    fun getDataFromServer(): Flow<String> = flow {
        delay(2000)
        emit( "Server Data One")
        delay(2000)
        emit( "Server Data Two")
        delay(2000)
        emit( "Server Data Three")
    }

    fun getToastData(): Flow<String> = flow {
        delay(2000)
        emit( "Get Toast")
    }
}