package com.dicoding.picodiploma.myapp_mystore

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnHome: Button
    companion object{
        const val DATA = "data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val photo: ImageView = findViewById(R.id.img_item_photo)
        val name: TextView = findViewById(R.id.tv_item_name)
        val descrition: TextView = findViewById(R.id.tv_item_description)
        val bahan: TextView = findViewById(R.id.tv_item_bahan)
        btnHome = findViewById(R.id.btn_home)

        btnHome.setOnClickListener(this)

        val data = intent.getParcelableExtra<Food>(DATA)

        if (data != null){
            val nama = "${data.name.toString()}"
            val deskripsi = "${data.description}"
            val bhn = "Bahan = ${data.bahan}"
            name.text = nama
            descrition.text = deskripsi
            Glide.with(this).load(data.photo).into(photo)
            bahan.text = bhn
        }
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_home){
            val homeIntent = Intent(this@DetailActivity, MainActivity::class.java)
            startActivity(homeIntent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.profil -> {
                val profilIntent = Intent(this@DetailActivity, ProfilActivity::class.java)
                startActivity(profilIntent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}