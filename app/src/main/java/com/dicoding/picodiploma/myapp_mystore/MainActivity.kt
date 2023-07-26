package com.dicoding.picodiploma.myapp_mystore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    private lateinit var rvFood: RecyclerView
    private val list = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFood = findViewById(R.id.rv_food)
        rvFood.setHasFixedSize(true)

        list.addAll(getListFood())
        showRecyclerList()
    }

    private fun getListFood(): ArrayList<Food>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataBahan = resources.getStringArray(R.array.data_bahan)
        val listFood = ArrayList<Food>()
        for (i in dataName.indices){
            val food = Food(dataName[i], dataDescription[i], dataPhoto[i], dataBahan[i])
            listFood.add(food)
        }
        return listFood
    }

    private fun showRecyclerList(){
        rvFood.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        rvFood.adapter = listFoodAdapter

        listFoodAdapter.setOnItemClickCallback(object : ListFoodAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Food) {
                showSelectedFood(data)
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra(DetailActivity.DATA, data)
                startActivity(intentToDetail)
            }
        })
    }

    private fun showSelectedFood(food: Food){
        Toast.makeText(this, "Kamu memilih " + food.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.profil -> {
                val profilIntent = Intent(this@MainActivity, ProfilActivity::class.java)
                startActivity(profilIntent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}