package com.example.deron.t2_MVVM_Flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MVVMFactoryFlow(private val repository: MVVMRepositoryFlow) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MVVMVIewModelFlow(repository) as T
    }
}
