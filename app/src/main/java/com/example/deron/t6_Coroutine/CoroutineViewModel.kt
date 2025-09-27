package com.example.deron.t6_Coroutine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deron.t7_Retrofit.Network
import com.example.deron.t7_Retrofit.Request.UserReq
import com.example.deron.t7_Retrofit.Response.User
import com.example.deron.util.Tool
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CoroutineViewModel @Inject constructor() : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val _time = MutableLiveData("00:00:00")
    val time: LiveData<String> = _time

    private val _toast = MutableLiveData("")
    val toast: LiveData<String> = _toast

    fun getUser(userName: String) {
        val userReq = UserReq(name = userName)

        // viewModelScope 預設在 Main Thread
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                Network.api.getUserByCoroutine(userReq)
            }

            if (response.isSuccessful && response.body()?.rtnCode == 200) {
                // Successful
                val userList = response.body()?.data
                if (userList != null && userList.isNotEmpty()) {
                    _user.value = userList.first()
                } else {
                    _toast.value = "查無資料"
                }
            }

            if (!response.isSuccessful) {
                // HTTP Error
                _toast.value = "HTTP Error ${response.code()}"
            }

            if (response.body()?.rtnCode != 200) {
                // Server Error
                _toast.value = "Server Error ${response.body()?.rtnCode}"
            }
        }
    }

    fun startStopWatch() {
        viewModelScope.launch {
            var num = 0
            while (true) {
                delay(1000) // delay 本身就是 suspend fun 所以不用 IO
                num++
                _time.value = Tool.intToHMS(num)
            }
        }
    }

}