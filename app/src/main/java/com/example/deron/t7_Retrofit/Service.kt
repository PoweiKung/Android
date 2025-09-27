package com.example.deron.t7_Retrofit

import com.example.deron.t7_Retrofit.Request.UserReq
import com.example.deron.t7_Retrofit.Response.User
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

object Network {
    private val client = OkHttpClient().newBuilder()
        .retryOnConnectionFailure(false)
        .connectTimeout(30L, TimeUnit.SECONDS)
        .readTimeout(90L, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("http://10.0.2.2:3001/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(APIService::class.java)
}

interface APIService {
    @POST("android/getUser")
    @Headers("Content-Type: application/json")
    fun getUser(@Body request: UserReq): Call<BaseResponse<MutableList<User>>>

    @POST("android/getUser")
    @Headers("Content-Type: application/json")
    suspend fun getUserByCoroutine(@Body request: UserReq): Response<BaseResponse<MutableList<User>>>
}

