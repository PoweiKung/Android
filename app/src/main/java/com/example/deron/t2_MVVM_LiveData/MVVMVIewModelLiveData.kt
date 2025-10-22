package com.example.deron.t2_MVVM_LiveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MVVMVIewModelLiveData(private val repository: MVVMRepositoryLiveData) : ViewModel() {
    private val _user = MutableLiveData("Initial") // LiveData + set
    val user: LiveData<String> = _user // read only data

    fun uploadData() {
        viewModelScope.launch {
            val data = repository.getDataFromServer()
            _user.value = data
        }
    }
}