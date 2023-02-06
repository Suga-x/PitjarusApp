package com.example.pitjarusapp.API


import com.example.pitjarusapp.LoginResponse
import com.example.pitjarusapp.rvListTokoModel
import retrofit2.Call
import retrofit2.Callback

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginApi {
    @FormUrlEncoded
    @POST("login/loginTest")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call <LoginResponse>

}
interface getData{
    @GET("posts")
    fun listTokoData(): Call<ArrayList<rvListTokoModel>>
}

