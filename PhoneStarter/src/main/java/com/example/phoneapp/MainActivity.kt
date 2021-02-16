package com.example.phoneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.api.Verify

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Verify.verifyPhoneApp()
    }
}
