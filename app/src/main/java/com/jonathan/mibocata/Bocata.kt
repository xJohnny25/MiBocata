package com.jonathan.mibocata

import java.time.LocalDate

data class Bocata (
    val nombre: String,
    val fecha : LocalDate?,
    val tipo: Boolean,
    val precio: Double,
    val ingredientes: List<String>,
    val alergenos: List<String>
)