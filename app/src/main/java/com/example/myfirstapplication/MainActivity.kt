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

        btn_watch.setOnClickListener {
            val i = Intent(this, MovieDetailActivity::class.java)
            startActivity(i)
        }

        btn_fragment2.setOnClickListener {
            var fr = supportFragmentManager.beginTransaction()
            fr.replace(R.id.fl_fragment, ExploreFragment())
            fr.commit()
        }

        var fr = supportFragmentManager.beginTransaction()
        fr.add(R.id.fl_fragment, HomeFragment())
        fr.commit()
    }

    override fun onPause() {
        super.onPause()

        var fr = supportFragmentManager.beginTransaction()
        fr.replace(R.id.fl_fragment, HomeFragment())
        fr.commit()
    }
}