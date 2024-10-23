package com.jonathan.mibocata

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BocataHistorial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bocata_historial)

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
                null,
                true,
                25.00,
                tiposBocata[0],
                listOf("1", "4")
            ),
            Bocata(
                "Bocata de Jamón York",
                null,
                true,
                22.00,
                tiposBocata[1],
                listOf("2", "5")
            ),
            Bocata(
                "Bocata de Sobrasada y Miel",
                null,
                true,
                20.00,
                tiposBocata[2],
                listOf("3", "7")
            ),
            Bocata(
                "Bocata de Chorizo y Queso de Cabra",
                null,
                true,
                23.00,
                tiposBocata[3],
                listOf("4", "8")
            ),
            Bocata(
                "Bocata de Atún y Tomate",
                null,
                true,
                18.00,
                tiposBocata[4],
                listOf("1", "6")
            ),
            Bocata(
                "Bocata de Pavo y Aguacate",
                null,
                true,
                24.00,
                tiposBocata[5],
                listOf("2", "9")
            ),
            Bocata(
                "Bocata de Lomo Embuchado y Pimientos",
                null,
                true,
                21.00,
                tiposBocata[6],
                listOf("3", "7")
            ),
            Bocata(
                "Bocata de Salami y Queso Suizo",
                null,
                true,
                19.00,
                tiposBocata[7],
                listOf("5", "10")
            ),
            Bocata(
                "Bocata de Pollo Asado y Espinaca",
                null,
                true,
                22.50,
                tiposBocata[8],
                listOf("6", "9")
            ),
            Bocata(
                "Bocata de Queso Brie y Membrillo",
                null,
                true,
                26.00,
                tiposBocata[9],
                listOf("1", "8")
            )
        )
    }
}