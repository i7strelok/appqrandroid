package com.example.appqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class NewUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)
        com.example.appqr.Toolbar().show(this, "Nueva usuario", true)
        findViewById<Toolbar>(R.id.toolbarGeneral).setNavigationOnClickListener(){
            intent = Intent(this, UsersList::class.java)
            startActivity(intent)
        }
    }
}