package com.example.deron.t8_Fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MyFragmentViewModel @Inject constructor() : ViewModel() {

    private val _data = MutableLiveData("Old Data")
    val data: LiveData<String> = _data


    fun updateData() {
        val newData = "New Data"
        _data.value = newData
    }

}