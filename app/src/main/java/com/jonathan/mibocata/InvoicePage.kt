package com.jonathan.mibocata

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDate

class InvoicePage : AppCompatActivity() {
    private lateinit var userAccountIcon: ImageView
    private lateinit var calendaIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_invoice_page)

        userAccountIcon = findViewById(R.id.userAccountIcon)
        calendaIcon = findViewById(R.id.calendarIcon)

        val tiposBocata = listOf(
            listOf(
                "Jamón Serrano",
                "Aceite",
                "Queso",
                "Pan de centeno"
            ),
            listOf(
                "Jamón York",
                "Aceite",
                "Queso",
                "Pan de centeno"
            ),
            listOf(
                "Sobrasada",
                "Miel",
                "Pan integral"
            ),
            listOf(
                "Chorizo",
                "Queso de cabra",
                "Pan rústico"
            ),
            listOf(
                "Atún",
                "Tomate",
                "Mayonesa",
                "Pan de molde"
            ),
            listOf(
                "Pechuga de pavo",
                "Aguacate",
                "Queso fresco",
                "Pan integral"
            ),
            listOf(
                "Lomo embuchado",
                "Pimientos asados",
                "Pan de chapata"
            ),
            listOf(
                "Salami",
                "Queso suizo",
                "Mostaza",
                "Pan blanco"
            ),
            listOf(
                "Pollo asado",
                "Hojas de espinaca",
                "Alioli",
                "Pan de pita"
            ),
            listOf(
                "Queso brie",
                "Membrillo",
                "Nueces",
                "Pan de nueces"
            )
        )

        val listaBocatas = listOf(
            Bocata(
                "Bocata de Jamón Serrano",
                LocalDate.of(2024, 11, 10),
                true,
                25.00,
                tiposBocata[0],
                listOf("1", "4")
            ),
            Bocata(
                "Bocata de Jamón York",
                LocalDate.of(2024, 11, 10),
                false,
                22.00,
                tiposBocata[1],
                listOf("2", "5")
            ),
            Bocata(
                "Bocata de Sobrasada y Miel",
                LocalDate.of(2024, 11, 11),
                true,
                20.00,
                tiposBocata[2],
                listOf("3", "7")
            )
        )

        userAccountIcon.setOnClickListener {
            val intent = Intent(this, UserAccountPage::class.java)
            startActivity(intent)
        }

        calendaIcon.setOnClickListener {
            val intent = Intent(this, SandwichCalendar::class.java)
            startActivity(intent)
        }

        val listView = findViewById<ListView>(R.id.listView)

        val adapter = SandwichAdapter(this, listaBocatas)

        listView.adapter = adapter
    }
}