package com.example.pitjarusapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.pitjarusapp.API.LoginPitjarus


class MainActivity : AppCompatActivity() {
    private var etUsername : EditText ?=null
    private var etPassword : EditText ?=null
    private var btnLogin : Button? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = LoginPitjarus()
        supportActionBar?.hide()
        etUsername = findViewById(R.id.et_Username)
        etPassword = findViewById(R.id.et_Password)
        btnLogin =findViewById(R.id.buttonLogin)

        btnLogin!!.setOnClickListener{
            val uname = etUsername!!.text.toString().trim()
            val passwrd = etPassword!!.text.toString().trim()
            if (uname.isEmpty() || passwrd.isEmpty()) {
                Toast.makeText(this, "Please enter your username and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
                repository.login(uname,passwrd,
                    onSuccess = {
                        val intent = Intent(this@MainActivity, HomeActivity::class.java)
                        intent.putExtra("EXTRA_NAME",uname)
                        startActivity(intent)

                    }, onError = {
                        it
                        Toast.makeText(this, "dont match", Toast.LENGTH_SHORT).show()
                        Log.d("error login", it.toString())
                    })
            }

        }



    }

}