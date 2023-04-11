package com.example.clickcountbutton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import androidx.core.app.ShareCompat.IntentReader

class Final : AppCompatActivity() {
   // val homeButton=findViewById<ImageButton>(R.id.homeButton)
    //val pieButton=findViewById<ImageButton>(R.id.pieButton)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        setSupportActionBar(findViewById(R.id.final_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        /*homeButton.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        pieButton.setOnClickListener{
            val intent=Intent(this,PieChart::class.java)
            startActivity(intent)
            finish()
        }*/

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.opt_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.piechart ->
            {
                val intent= Intent(this,PieChart::class.java)
                startActivity(intent)
                finish()
                return true
            }
            else ->  return super.onOptionsItemSelected(item)
        }
    }

}