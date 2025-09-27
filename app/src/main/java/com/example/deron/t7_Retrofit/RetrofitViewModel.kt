package com.example.deron.t7_Retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deron.t7_Retrofit.Request.UserReq
import com.example.deron.t7_Retrofit.Response.User
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class RetrofitViewModel @Inject constructor() : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun getUser() {
        val userReq = UserReq(name = "Takeda")
        Network.api.getUser(userReq).enqueue(object : Callback<BaseResponse<MutableList<User>>> {
            override fun onResponse(
                base: Call<BaseResponse<MutableList<User>>>,
                response: Response<BaseResponse<MutableList<User>>>
            ) {
                if (response.isSuccessful && response.body()?.rtnCode == 200) {
                    // Successful
                    val userList = response.body()?.data
                    if (userList != null && userList.isNotEmpty()) _user.value = userList.first()
                }

                if (!response.isSuccessful) {
                    // HTTP Error

                }

                if (response.body()?.rtnCode != 200) {
                    // Server Error
                }
            }

            override fun onFailure(call: Call<BaseResponse<MutableList<User>>>, t: Throwable) {
                // Network Error (DNS、timeout and so on...)
                Log.v("test__", "Failure")
            }
        })
    }

}