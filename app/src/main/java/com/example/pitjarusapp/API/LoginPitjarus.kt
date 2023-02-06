package com.example.pitjarusapp.API

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.pitjarusapp.LoginResponse
import com.example.pitjarusapp.rvListTokoModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginPitjarus {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    val okHttpClient = OkHttpClient.Builder()
        .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://dev.pitjarus.co/api/sariroti_md/index.php/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val loginApi:LoginApi = retrofit.create(LoginApi::class.java)

    fun login(username: String, password: String, onSuccess: (LoginResponse) -> Unit, onError: (Throwable) -> Unit) {
        loginApi.login(username, password)
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            onSuccess(it)
                        }
                    } else {
                        onError(Throwable("Error"))
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    onError(t)
                }
            })
    }

}
