package com.jonathan.mibocata

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class UserAccountPage : AppCompatActivity() {
    private lateinit var invoiceIcon: ImageView
    private lateinit var calendaIcon: ImageView
    private lateinit var logoApp: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_account)

        invoiceIcon = findViewById(R.id.invoiceIcon)
        calendaIcon = findViewById(R.id.calendarIcon)
        logoApp = findViewById(R.id.logoApp)

        invoiceIcon.setOnClickListener {
            val intent = Intent(this, InvoicePage::class.java)
            startActivity(intent)
        }

        calendaIcon.setOnClickListener {
            val intent = Intent(this, SandwichCalendar::class.java)
            startActivity(intent)
        }

        logoApp.setOnClickListener {
            val intent = Intent(this, SandwichChooseScreen::class.java)
            startActivity(intent)
        }
    }
}