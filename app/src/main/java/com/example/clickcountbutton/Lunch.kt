package com.example.clickcountbutton

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class Lunch : AppCompatActivity() {
    private var biryaniC = 0
    private var kormaC= 0
    private var nehariC = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunch)
        setSupportActionBar(findViewById(R.id.lunch_toolbar))
        val sharedPref = this.getSharedPreferences("my_app_preferences", Context.MODE_PRIVATE)

        val biryani=findViewById<Button>(R.id.biryani)
        val korma=findViewById<Button>(R.id.korma)
        val nehari=findViewById<Button>(R.id.nehari)
        val intent=Intent(this,Dinner::class.java)

        biryani.setOnClickListener{
            biryaniC++
            Log.d("message","biryani is clicked $biryaniC times")
            sharedPref.edit().putInt("biryani_clicks", biryaniC ).apply()
            sharedPref.edit().commit()
            startActivity(intent)

        }
        korma.setOnClickListener{
            kormaC++
            Log.d("message","korma is clicked $kormaC times")
            sharedPref.edit().putInt("korma_clicks", kormaC ).apply()
            sharedPref.edit().commit()
            startActivity(intent)

        }
        nehari.setOnClickListener{
            nehariC++
            Log.d("message","Nehari is clicked $nehariC times")
            sharedPref.edit().putInt("nehari_clicks", nehariC ).apply()
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