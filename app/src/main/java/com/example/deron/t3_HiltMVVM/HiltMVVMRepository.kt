package com.example.deron.t3_HiltMVVM

import javax.inject.Inject

class HiltMVVMRepository @Inject constructor() {
    fun getDataFromServer(): String {
        return "Server Data"
    }
}