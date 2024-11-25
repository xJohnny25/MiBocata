package com.jonathan.mibocata

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalendarAdapter (
    private val context: AppCompatActivity,
    private val listaProductos: List<Bocata>) :
    BaseAdapter() {
        override fun getCount(): Int {
            return listaProductos.size
        }

        override fun getItem(p0: Int): Bocata {
            return listaProductos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val view : View = p1 ?: LayoutInflater.from(context).inflate(R.layout.calendar, p2, false)

            val producto = getItem(p0)

            val fecha = view.findViewById<TextView>(R.id.calendarSandwichDate)
            val nombre = view.findViewById<TextView>(R.id.calendarSandwichName)

            fecha.text = producto.fecha
            nombre.text = producto.nombre

            if (producto.tipo){
                fecha.setTextColor(Color.parseColor("#35C64A"))
            } else {
                fecha.setTextColor(Color.parseColor("#F28162"))
            }

            return view
        }
    }
