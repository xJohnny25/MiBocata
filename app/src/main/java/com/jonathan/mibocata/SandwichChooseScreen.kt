package com.jonathan.mibocata

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SandwichChooseScreen : AppCompatActivity() {
    private lateinit var invoiceIcon: ImageView
    private lateinit var userAccountIcon: ImageView
    private lateinit var calendaIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sandwich_choose_screen)

        invoiceIcon = findViewById(R.id.invoiceIcon)
        userAccountIcon = findViewById(R.id.userAccountIcon)
        calendaIcon = findViewById(R.id.calendarIcon)

        invoiceIcon.setOnClickListener {
            val intent = Intent(this, InvoicePage::class.java)
            startActivity(intent)
        }

        userAccountIcon.setOnClickListener {
            val intent = Intent(this, UserAccountPage::class.java)
            startActivity(intent)
        }

        calendaIcon.setOnClickListener {
            val intent = Intent(this, SandwichCalendar::class.java)
            startActivity(intent)
        }
    }
}