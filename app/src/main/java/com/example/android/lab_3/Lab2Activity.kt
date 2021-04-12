package com.example.android.lab_3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Lab2Activity : AppCompatActivity() {
    lateinit var receiver: BroadcastReceiver
    lateinit var btnToCam: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab2)


        receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {

                if (Intent.ACTION_AIRPLANE_MODE_CHANGED == intent?.action) {
                    val isAirplaneModeEnabled = intent.getBooleanExtra("state", false)
                    if (isAirplaneModeEnabled) Toast.makeText(
                        context,
                        "Airplane Mode enabled",
                        Toast.LENGTH_LONG
                    ).show()
                    else Toast.makeText(context, "Airplane Mode disabled", Toast.LENGTH_LONG).show()
                }
                if (Intent.ACTION_BATTERY_LOW == intent?.action) {
                    Toast.makeText(context, "Battery low", Toast.LENGTH_LONG).show()
                }

            }
        }

        val filter = IntentFilter()
        filter.apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            addAction(Intent.ACTION_BATTERY_LOW)

        }

        registerReceiver(receiver, filter)

    }


    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }

}