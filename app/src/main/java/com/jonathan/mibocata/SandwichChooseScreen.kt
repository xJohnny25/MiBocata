package com.jonathan.mibocata

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.w3c.dom.Text
import java.io.InputStreamReader
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

class SandwichChooseScreen : AppCompatActivity() {
    private lateinit var invoiceIcon: ImageView
    private lateinit var userAccountIcon: ImageView
    private lateinit var calendarIcon: ImageView
    private lateinit var coldView: View
    private lateinit var hotView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sandwich_choose_screen)

        invoiceIcon = findViewById(R.id.invoiceIcon)
        userAccountIcon = findViewById(R.id.userAccountIcon)
        calendarIcon = findViewById(R.id.calendarIcon)

        coldView = findViewById(R.id.view3)
        hotView = findViewById(R.id.view4)

        val bocadilloFrioTexto = findViewById<TextView>(R.id.bocadilloFrioTexto)
        val bocadilloCalienteTexto = findViewById<TextView>(R.id.bocadilloCalienteTexto)

        changeNameSandwichCalendar(bocadilloCalienteTexto, bocadilloFrioTexto)

        coldView.setOnClickListener {
            Toast.makeText(this, "Tu pedido se empezará a preparar pronto", Toast.LENGTH_SHORT).show()
        }

        hotView.setOnClickListener {
            Toast.makeText(this, "Tu pedido se empezará a preparar pronto", Toast.LENGTH_SHORT).show()
        }

        invoiceIcon.setOnClickListener {
            val intent = Intent(this, InvoicePage::class.java)
            startActivity(intent)
        }

        userAccountIcon.setOnClickListener {
            val intent = Intent(this, UserAccountPage::class.java)
            startActivity(intent)
        }

        calendarIcon.setOnClickListener {
            val intent = Intent(this, SandwichCalendar::class.java)
            startActivity(intent)
        }
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

        val today = LocalDate.now().dayOfWeek

        val todayName = today.getDisplayName(TextStyle.FULL, Locale("es", "ES"))

        for (bocata in bocatas) {
            if (bocata.dia?.lowercase() == todayName.toString() && !bocata.tipo) {
                hotsandwich.text = bocata.nombre
            } else if (bocata.dia?.lowercase() == todayName.toString()) {
                coldSandwich.text = bocata.nombre
            }
        }
    }
}