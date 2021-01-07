package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Main Activity", "onCreate")

        var fr = supportFragmentManager.beginTransaction()
        fr.add(R.id.fl_fragment, HomeFragment())
        fr.commit()
    }
}