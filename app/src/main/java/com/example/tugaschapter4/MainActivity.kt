package com.example.tugaschapter4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugaschapter4.sharedpreference.SPScreen1Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_shared_preference.setOnClickListener {
            startActivity(Intent(this, SPScreen1Activity::class.java))
        }
    }
}