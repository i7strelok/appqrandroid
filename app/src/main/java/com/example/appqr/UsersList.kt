package com.example.appqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class UsersList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_list)
        com.example.appqr.Toolbar().show(this, "Usuarios", true)
        findViewById<Toolbar>(R.id.toolbarGeneral).setNavigationOnClickListener(){
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val buttonNew=findViewById<Button>(R.id.addNewUser)
        buttonNew.setOnClickListener {
            intent = Intent(this, NewUser::class.java)
            startActivity(intent)
        }
    }
}