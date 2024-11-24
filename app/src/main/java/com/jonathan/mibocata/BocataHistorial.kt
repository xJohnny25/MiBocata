package com.jonathan.mibocata

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate

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


    }
}