package com.jonathan.mibocata

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDate

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
                "Bocata de tortilla",
                LocalDate.of(2024, 11, 25),
                true,
                25.00,
                tiposBocata[0],
                listOf("1", "4")
            ),
            Bocata(
                "Bocata de Jamón York",
                LocalDate.of(2024, 11, 26),
                false,
                22.00,
                tiposBocata[1],
                listOf("2", "5")
            ),
            Bocata(
                "Cigarro y café",
                LocalDate.of(2024, 11, 27),
                true,
                20.00,
                tiposBocata[2],
                listOf("3", "7")
            ),
            Bocata(
                "Bocata para Paula",
                LocalDate.of(2024, 11, 28),
                false,
                23.00,
                tiposBocata[3],
                listOf("4", "8")
            ),
            Bocata(
                "Bocata de Atún y Tomate",
                LocalDate.of(2024, 11, 29),
                true,
                18.00,
                tiposBocata[4],
                listOf("1", "6")
            ),
            Bocata(
                "Bocata de Pavo y Aguacate",
                LocalDate.of(2024, 11, 30),
                false,
                24.00,
                tiposBocata[5],
                listOf("2", "9")
            ),
            Bocata(
                "Bocata de calamares",
                LocalDate.of(2024, 12, 1),
                true,
                21.00,
                tiposBocata[6],
                listOf("3", "7")
            ),
            Bocata(
                "Bocata de Salami",
                LocalDate.of(2024, 12, 2),
                false,
                19.00,
                tiposBocata[7],
                listOf("5", "10")
            ),
            Bocata(
                "Bocata de Pollo",
                LocalDate.of(2024, 12, 3),
                true,
                22.50,
                tiposBocata[8],
                listOf("6", "9")
            ),
            Bocata(
                "Bocata de Queso",
                LocalDate.of(2024, 12, 4),
                false,
                26.00,
                tiposBocata[9],
                listOf("1", "8")
            )
        )

        val listView = findViewById<GridView>(R.id.gridView)

        val adapter = CalendarAdapter(this, listaBocatas)

        listView.adapter = adapter
    }
}