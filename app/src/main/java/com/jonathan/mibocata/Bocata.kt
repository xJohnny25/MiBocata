package com.jonathan.mibocata

data class Bocata (
    val nombre: String,
    val fecha : String?,
    val tipo: Boolean,
    val precio: Double,
    val ingredientes: List<String>,
    val alergenos: List<String>
)