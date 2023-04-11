package com.example.clickcountbutton

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class Dinner : AppCompatActivity() {
    private var kebabC = 0
    private var koftaC= 0
    private var polaoC = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dinner)
        setSupportActionBar(findViewById(R.id.dinner_toolbar))

        val sharedPref = this.getSharedPreferences("my_app_preferences", Context.MODE_PRIVATE)
        val kebab=findViewById<Button>(R.id.kebab)
        val kofta=findViewById<Button>(R.id.kofta)
        val polao=findViewById<Button>(R.id.polao)
        val intent=Intent(this,Final::class.java)

        kebab.setOnClickListener{
            kebabC++
            Log.d("message","Kebab has click $kebabC times")
            sharedPref.edit().putInt("kebab_Clicks",kebabC).apply()
            sharedPref.edit().commit()
            startActivity(intent)
        }

        kofta.setOnClickListener{
            koftaC++
            Log.d("message","Kofta has click $koftaC times")
            sharedPref.edit().putInt("kofta_Clicks",koftaC).apply()
            sharedPref.edit().commit()
            startActivity(intent)
        }
        polao.setOnClickListener{
            polaoC++
            Log.d("message","Polao has click $polaoC times")
            sharedPref.edit().putInt("polao_Clicks",polaoC).apply()
            sharedPref.edit().commit()
            startActivity(intent)
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.opt_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.piechart -> {
                val intent= Intent(this,PieChart::class.java)
                startActivity(intent)
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)

        }

    }
}