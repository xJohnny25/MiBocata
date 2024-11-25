package com.jonathan.mibocata

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_invoice_page)

        userAccountIcon = findViewById(R.id.userAccountIcon)
        calendarIcon = findViewById(R.id.calendarIcon)

        val listaBocatas = loadProducts(this)

        userAccountIcon.setOnClickListener {
            val intent = Intent(this, UserAccountPage::class.java)
            startActivity(intent)
        }

        calendarIcon.setOnClickListener {
            val intent = Intent(this, SandwichCalendar::class.java)
            startActivity(intent)
        }

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