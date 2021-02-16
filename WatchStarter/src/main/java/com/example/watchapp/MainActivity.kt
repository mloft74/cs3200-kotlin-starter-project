package com.example.watchapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.api.Verify

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Verify.verifyWatchApp()
    }
}
