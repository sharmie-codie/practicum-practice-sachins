package com.example.practicumpractice

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Makeshiftsplashscreen : AppCompatActivity() {
    private val displayLength = 3000L // 3 seconds
    private lateinit var btnCon : Button
    private lateinit var btnExit : Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_makeshiftsplashscreen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnCon = findViewById(R.id.btnCon)
        btnExit = findViewById(R.id.btnExit)
        btnExit.setOnClickListener{
            Log.d("Button clicked", "onCreate: Exit")
            finishAffinity() // closes entire app as well all other activities
        }
        btnCon.setOnClickListener{
            Log.d("Button clicked", "onCreate: Continue")
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, displayLength)
        }
    }
}