package com.jonathan.mibocata

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var userField: EditText
    private lateinit var passwordField: EditText
    private lateinit var loginButton: Button
    private lateinit var userText: String
    private lateinit var passText: String

    private var userPrueba = "Usuario"
    private var passPrueba = "1234"

    companion object{
        fun navigatiBetweenPages(activity: Activity, claseDestino: Class<*>){
            val intent = Intent(activity, claseDestino)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        userField = findViewById(R.id.userField)
        passwordField = findViewById(R.id.passwordField)
        loginButton = findViewById(R.id.submitButton)

        loginButton.setOnClickListener{
            userText = userField.text.toString()
            passText = passwordField.text.toString()

            if (userText.isBlank() || passText.isBlank()){
                Toast.makeText(this, "El campo no puede estar vacío", Toast.LENGTH_LONG).show()
            }else if (userText.equals(userPrueba) || passText.equals(passPrueba)) {
                navigatiBetweenPages(this, SanwichChooseScreen::class.java)
            }else{
                Toast.makeText(this, "El usuario o la contraseña no existen", Toast.LENGTH_LONG).show()
            }
        }
    }
}