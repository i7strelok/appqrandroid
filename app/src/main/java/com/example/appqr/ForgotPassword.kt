package com.example.appqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar


class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        //ToolBar
        com.example.appqr.Toolbar().show(this, "Recuperar contraseña", true)
        findViewById<Toolbar>(R.id.toolbarGeneral).setNavigationOnClickListener(){
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val buttonReset=findViewById<Button>(R.id.reset)
        val email=findViewById<EditText>(R.id.emailForgotPassword)
        buttonReset.setOnClickListener {
            val email = email.text.toString()
            if(Seguridad().emailCheck(email)){
                Toast.makeText(this, "E-mail enviado", Toast.LENGTH_LONG).show()
            }
            else
                Toast.makeText(this, "E-mail no registrado", Toast.LENGTH_LONG).show()
        }
    }
}