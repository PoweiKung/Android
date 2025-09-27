package com.example.deron.t7_Retrofit

data class BaseResponse<T>(
    val data: T,
    val rtnCode: Int,
    val rtnMsg: String,
)