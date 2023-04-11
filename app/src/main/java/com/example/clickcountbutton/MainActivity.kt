package com.example.clickcountbutton

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class MainActivity : AppCompatActivity() {



    private var eggC = 0
    private var yogurtC= 0
    private var oatmealC = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        val sharedPref = this.getSharedPreferences("my_app_preferences", Context.MODE_PRIVATE)

        val oat=findViewById<Button>(R.id.oatmeal)
        val yogurt=findViewById<Button>(R.id.yogurt)
        val egg=findViewById<Button>(R.id.egg)
        val intent=Intent(this,Lunch::class.java)


         oat.setOnClickListener{
             oatmealC++
             Log.d("message","Oatmeal is clicked $oatmealC times")
             sharedPref.edit().putInt("oatmeal_clicks", oatmealC).apply()
             sharedPref.edit().commit()
             startActivity(intent)
         }
        yogurt.setOnClickListener{
            yogurtC++
            Log.d("message","Yogurt is clicked $yogurtC times")
            sharedPref.edit().putInt("yogurt_clicks", yogurtC ).apply()
            sharedPref.edit().commit()
            startActivity(intent)

        }
        egg.setOnClickListener{
            eggC++
            Log.d("message","egg is clicked $eggC times")
            sharedPref.edit().putInt("egg_clicks", eggC).apply()
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
                val intent=Intent(this,PieChart::class.java)
                startActivity(intent)
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)

        }

    }
}