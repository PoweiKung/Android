package com.example.deron.t2_MVVM_Flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MVVMVIewModelFlow(private val repository: MVVMRepositoryFlow) : ViewModel() {


    private val _user = MutableStateFlow("Initial") // LiveData + set
    val user: StateFlow<String> = _user // read only data
    fun uploadData() {
        viewModelScope.launch {
            try {
                repository.getDataFromServer().collect { data ->
                    _user.value = data
                }
            } catch (e: Exception) {
                _event.emit("Error: ${e.message}")
            }
        }
    }


    /** 事件用：一次性訊息、導航、Toast（SharedFlow） */
    private val _event = MutableSharedFlow<String>()
    val event: SharedFlow<String> = _event.asSharedFlow()

    /** 模擬載入資料 */
    fun uploadDataSharedFlow() {
        viewModelScope.launch {
            try {
                repository.getToastData().collect { data ->
                    // 資料載入完成後發送一次事件
                    _event.emit(data)
                }
            } catch (e: Exception) {
                _event.emit("Error: ${e.message}")
            }
        }
    }
}