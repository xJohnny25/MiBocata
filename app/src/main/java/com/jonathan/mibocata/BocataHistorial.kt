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

        val listaIngredientes = listOf(
            "Jamón Serrano",
            "Aceite",
            "Queso",
            "Pan de centeno"
        )

        val listaAlergenos = listOf(
            "1",
            "2",
            "3",
            "4"
        )

        val listaBocatas = listOf(
            Bocata("Bocata de Jamón", null, true, 25.00, listaIngredientes, listaAlergenos)
        )
    }
}