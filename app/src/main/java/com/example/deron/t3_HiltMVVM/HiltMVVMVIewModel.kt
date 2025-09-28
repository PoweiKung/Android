package com.example.deron.t3_HiltMVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 *  @HiltViewModel 告訴 Hilt 要自動生成 ViewModelFactory。
 *  @Inject constructor 告訴 Hilt 如何建立這個 ViewModel -> 需要 HiltMVVMRepository。
 */
@HiltViewModel
class HiltMVVMViewModel @Inject constructor(
    private val repository: HiltMVVMRepository
) : ViewModel() {
    private val _user = MutableLiveData("") // LiveData + set
    val user: LiveData<String> = _user // read only data

    fun uploadData() {
        val data = repository.getDataFromServer()
        _user.value = data

        // API 來的資料會改寫這樣(背景寫法)
        // _user.postValue(data)
    }
}