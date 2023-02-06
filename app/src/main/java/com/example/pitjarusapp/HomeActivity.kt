package com.example.pitjarusapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    private var tvNama : TextView?= null
    private var btnKunjungan : ImageView ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)
        supportActionBar?.hide()

        tvNama = findViewById(R.id.tvNama)
        val data = intent.getStringExtra("EXTRA_NAME")
        tvNama!!.setText(data)

        btnKunjungan = findViewById(R.id.btnKunjungan)
        btnKunjungan!!.setOnClickListener {
            val intent = Intent(this@HomeActivity, ListStore::class.java)
            startActivity(intent)
        }
    }
}