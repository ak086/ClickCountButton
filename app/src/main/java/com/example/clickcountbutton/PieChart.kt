package com.example.clickcountbutton

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class PieChart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie_chart)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val sharedPref = getSharedPreferences("my_app_preferences", Context.MODE_PRIVATE)

        val oatmealClicks = sharedPref.getInt("oatmeal_clicks", 0)
        val yogurtClicks = sharedPref.getInt("yogurt_clicks", 0)
        val eggClicks = sharedPref.getInt("egg_clicks", 0)
        val biryaniClicks=sharedPref.getInt("biryani_clicks",0)
        val nehariClicks=sharedPref.getInt("nehari_clicks",0)
        val kormaClicks=sharedPref.getInt("korma_clicks",0)
        val kebabClicks=sharedPref.getInt("kebab_clicks",0)
        val koftaClicks=sharedPref.getInt("kofta_clicks",0)
        val polaoClicks=sharedPref.getInt("polao_clicks",0)

        val entries = arrayListOf(
            PieEntry(oatmealClicks.toFloat(), "oatmeal"),
            PieEntry(yogurtClicks.toFloat(), "yogurt"),
            PieEntry(eggClicks.toFloat(), "egg") ,
            PieEntry(biryaniClicks.toFloat(), "biryani"),
            PieEntry(nehariClicks.toFloat(), "nehari"),
            PieEntry(kormaClicks.toFloat(), "korma"),
            PieEntry(kebabClicks.toFloat(), "kebab"),
            PieEntry(koftaClicks.toFloat(), "kofta"),
            PieEntry(polaoClicks.toFloat(), "polao")

        )

        val dataSet = PieDataSet(entries,"1")
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS.toList())
        val pieData = PieData(dataSet)

        val chart = findViewById<com.github.mikephil.charting.charts.PieChart>(R.id.chart)
        chart.data = pieData
        chart.isRotationEnabled = true
        chart.setEntryLabelColor(Color.BLACK)
        chart.setEntryLabelTextSize(12f)
        chart.animateY(1000)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}