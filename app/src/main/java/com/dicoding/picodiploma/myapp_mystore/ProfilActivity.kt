package com.dicoding.picodiploma.myapp_mystore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ProfilActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btn_home: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        btn_home = findViewById(R.id.btn_home)
        btn_home.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_home){
            val homeIntent = Intent(this@ProfilActivity, MainActivity::class.java)
            startActivity(homeIntent)
        }
    }
}