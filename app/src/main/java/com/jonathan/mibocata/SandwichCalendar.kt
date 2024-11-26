package com.jonathan.mibocata

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

class SandwichCalendar : AppCompatActivity() {
    private lateinit var invoiceIcon: ImageView
    private lateinit var userAccountIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sandwich_calendar)

        invoiceIcon = findViewById(R.id.invoiceIcon)
        userAccountIcon = findViewById(R.id.userAccountIcon)

        invoiceIcon.setOnClickListener {
            val intent = Intent(this, InvoicePage::class.java)
            startActivity(intent)
        }

        userAccountIcon.setOnClickListener {
            val intent = Intent(this, UserAccountPage::class.java)
            startActivity(intent)
        }

        val nextDayColdSandwichName = findViewById<TextView>(R.id.nextDayColdSandwichName)
        val nextDayHotSandwichName = findViewById<TextView>(R.id.nextDayHotSandwichName)
        
        changeNameSandwichCalendar(nextDayHotSandwichName, nextDayColdSandwichName)

        val listaBocatas = loadProducts(this)

        val gridView = findViewById<GridView>(R.id.gridView)

        val adapter = CalendarAdapter(this, listaBocatas)

        gridView.adapter = adapter
    }

    private fun loadProducts(context: Context): List<Bocata> {

        val inputStream = resources.openRawResource(R.raw.calendario)
        val reader = InputStreamReader(inputStream)
        val type = object : TypeToken<List<Bocata>>() {}.type

        val bocatas : List<Bocata> = Gson().fromJson(reader, type)

        return bocatas
    }

    private fun changeNameSandwichCalendar(hotsandwich: TextView, coldSandwich: TextView) {
        val bocatas = loadProducts(this)

        val tomorrow = LocalDate.now().dayOfWeek.plus(1)

        val tomorrowName = tomorrow.getDisplayName(TextStyle.FULL, Locale("es", "ES"))

        for (bocata in bocatas) {
            if (bocata.dia?.lowercase() == tomorrowName.toString() && !bocata.tipo) {
                hotsandwich.text = bocata.nombre
            } else if (bocata.dia?.lowercase() == tomorrowName.toString()) {
                coldSandwich.text = bocata.nombre
            }
        }
    }
}