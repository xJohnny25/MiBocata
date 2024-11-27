package com.jonathan.mibocata

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import java.time.LocalDate

class InvoicePage : AppCompatActivity() {
    private lateinit var userAccountIcon: ImageView
    private lateinit var calendarIcon: ImageView
    private lateinit var totalPrice: TextView
    private lateinit var coldSandwichCount: TextView
    private lateinit var hotSandwichCount: TextView
    private lateinit var logoApp: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_invoice_page)

        var coldCounter = 0;
        var hotCounter = 0;
        var price = 0;

        userAccountIcon = findViewById(R.id.userAccountIcon)
        calendarIcon = findViewById(R.id.calendarIcon)
        logoApp = findViewById(R.id.logoApp)
        totalPrice = findViewById(R.id.price)
        coldSandwichCount = findViewById(R.id.coldSandwichCount)
        hotSandwichCount = findViewById(R.id.hotSandwichCount)

        val listaBocatas = loadProducts(this)

        for (bocata in listaBocatas) {
            if (bocata.tipo) {
                coldCounter++
            } else {
                hotCounter++
            }
            price += bocata.precio.toInt()
        }

        userAccountIcon.setOnClickListener {
            val intent = Intent(this, UserAccountPage::class.java)
            startActivity(intent)
        }

        calendarIcon.setOnClickListener {
            val intent = Intent(this, SandwichCalendar::class.java)
            startActivity(intent)
        }

        logoApp.setOnClickListener {
            val intent = Intent(this, SandwichChooseScreen::class.java)
            startActivity(intent)
        }

        totalPrice.text = "$price€"
        coldSandwichCount.text = coldCounter.toString()
        hotSandwichCount.text = hotCounter.toString()

        val listView = findViewById<ListView>(R.id.listView)

        val adapter = SandwichAdapter(this, listaBocatas)

        listView.adapter = adapter
    }

    private fun loadProducts(context: Context): List<Bocata> {

        val inputStream = resources.openRawResource(R.raw.pedidos)
        val reader = InputStreamReader(inputStream)
        val type = object : TypeToken<List<Pedidos>>() {}.type

        val pedidos : List<Pedidos> = Gson().fromJson(reader, type)
        val bocatas : List<Bocata> = pedidos[0].pedidos

        return bocatas
    }
}