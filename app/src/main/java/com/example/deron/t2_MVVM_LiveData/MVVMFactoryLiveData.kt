package com.example.deron.t2_MVVM_LiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MVVMFactoryLiveData(private val repository: MVVMRepositoryLiveData) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MVVMVIewModelLiveData(repository) as T
    }
}
