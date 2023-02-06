package com.example.pitjarusapp.API

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val okHttpClient = OkHttpClient.Builder()
        .build()
    val instance : LoginApi by lazy {
         val retrofit = Retrofit.Builder()
            .baseUrl("http://dev.pitjarus.co/api/sariroti_md/index.php/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(LoginApi::class.java)
    }
}