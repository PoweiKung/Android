package com.example.deron.t2_MVVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MVVMFactory(private val repository: MVVMRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MVVMViewModel(repository) as T
    }
}
