package com.example.appqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        com.example.appqr.Toolbar().show(this, "Menú principal", false)
        val buttonScanQR=findViewById<Button>(R.id.scanqr)
        val buttonSearch=findViewById<Button>(R.id.search)
        val buttonEquipments=findViewById<Button>(R.id.equipments)
        val buttonAreas=findViewById<Button>(R.id.areas)
        val buttonUsers=findViewById<Button>(R.id.users)
        buttonScanQR.setOnClickListener {
            intent = Intent(this, ScanQr::class.java)
            startActivity(intent)
        }
        buttonSearch.setOnClickListener {
           /* intent = Intent(this, EquipmentSearch::class.java)
            startActivity(intent)*/
        }
        buttonEquipments.setOnClickListener {
            intent = Intent(this, EquipmentsList::class.java)
            startActivity(intent)
        }
        buttonAreas.setOnClickListener {
            intent = Intent(this, AreasList::class.java)
            startActivity(intent)
        }
        buttonUsers.setOnClickListener {
            intent = Intent(this, UsersList::class.java)
            startActivity(intent)
        }
    }
    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.account -> {
                Toast.makeText(applicationContext, "Click en Cuenta", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.logout -> {
                Toast.makeText(applicationContext, "Click en Logout", Toast.LENGTH_LONG).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}