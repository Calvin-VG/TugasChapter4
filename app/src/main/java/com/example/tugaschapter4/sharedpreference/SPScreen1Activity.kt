package com.example.tugaschapter4.sharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugaschapter4.R
import kotlinx.android.synthetic.main.activity_spscreen1.*

class SPScreen1Activity : AppCompatActivity() {
    lateinit var tugassp : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spscreen1)

        if (getSharedPreferences("Tugas", Context.MODE_PRIVATE).contains("USERNAME") &&
            getSharedPreferences("Tugas", Context.MODE_PRIVATE).contains("PASSWORD")){
            startActivity(Intent(this, SPScreen2Activity::class.java))
        }

        tugassp = getSharedPreferences("Tugas", Context.MODE_PRIVATE)

        btn_sp_login.setOnClickListener {
            val username = et_sp_username.text.toString()
            val password = et_sp_password.text.toString()
            val sp = tugassp.edit()
            sp.putString("USERNAME", username)
            sp.putString("PASSWORD", password)
            sp.apply()

            startActivity(Intent(this, SPScreen2Activity::class.java))
            finish()
        }
    }
}