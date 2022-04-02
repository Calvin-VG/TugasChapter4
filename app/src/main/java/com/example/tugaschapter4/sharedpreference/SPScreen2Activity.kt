package com.example.tugaschapter4.sharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.tugaschapter4.R
import kotlinx.android.synthetic.main.activity_spscreen2.*
import kotlinx.android.synthetic.main.custom_sp_alertdialog.view.*

class SPScreen2Activity : AppCompatActivity() {
    lateinit var tugassp2 : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spscreen2)

        tugassp2 = getSharedPreferences("Tugas", Context.MODE_PRIVATE)

        val ambilusername = tugassp2.getString("USERNAME", "")
        tv_sp_get_username.text = "Hello, $ambilusername"

        btn_sp_logout.setOnClickListener {
            logout()
        }
    }

    fun logout(){
        val customdialog = LayoutInflater.from(this).inflate(R.layout.custom_sp_alertdialog, null, false)
        val spcd = AlertDialog.Builder(this)
            .setView(customdialog)
            .create()

        customdialog.btn_sp_ya_logout.setOnClickListener {
            val logout = tugassp2.edit()
            logout.clear()
            logout.apply()

            startActivity(Intent(this, SPScreen1Activity::class.java))
            finish()
        }

        customdialog.btn_sp_tidak_logout.setOnClickListener {
            spcd.dismiss()
        }
        spcd.show()

    }
}