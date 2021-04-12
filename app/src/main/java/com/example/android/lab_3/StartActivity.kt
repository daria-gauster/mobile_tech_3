package com.example.android.lab_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val btnToLab1 = findViewById<Button>(R.id.btnToLab1)
        val btnToLab2 = findViewById<Button>(R.id.btnToLab2)

        btnToLab1.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    Lab1Activity::class.java
                )
            )
        }
        btnToLab2.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    Lab2Activity::class.java
                )
            )
        }

    }
}