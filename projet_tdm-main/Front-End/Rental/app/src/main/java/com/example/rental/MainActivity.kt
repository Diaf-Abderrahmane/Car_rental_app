package com.example.rental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
            finish()}, 3000)
        supportActionBar?.hide()

    }

    }
