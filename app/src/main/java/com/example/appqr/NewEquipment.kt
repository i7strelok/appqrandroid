package com.example.appqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class NewEquipment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_equipment)
        com.example.appqr.Toolbar().show(this, "Nueva equipo", true)
        findViewById<Toolbar>(R.id.toolbarGeneral).setNavigationOnClickListener(){
            intent = Intent(this, EquipmentsList::class.java)
            startActivity(intent)
        }
    }
}