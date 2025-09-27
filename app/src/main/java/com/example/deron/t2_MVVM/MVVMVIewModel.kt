package com.example.deron.t2_MVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MVVMViewModel(private val repository: MVVMRepository) : ViewModel() {
    private val _user = MutableLiveData<String>() // LiveData + set
    val user: LiveData<String> = _user // read only data

    fun uploadData() {
        val data = repository.getDataFromServer()
        _user.value = data

        // API 來的資料會改寫這樣(背景寫法)
        // _user.postValue(data)
    }
}