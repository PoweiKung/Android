package com.example.deron.t9_DialogFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DialogFragmentViewModel @Inject constructor() : ViewModel() {

    private val _data = MutableLiveData("please write something")
    val data: LiveData<String> = _data


    fun updateData() {
        val newData = "Hi everyone I'm Deron, this is my dialog fragment example"
        _data.value = newData
    }

}