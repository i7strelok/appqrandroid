package com.example.appqr


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        com.example.appqr.Toolbar().show(this, "Iniciar Sesión", false)
        val emailField=findViewById<EditText>(R.id.email)
        val passwordField=findViewById<EditText>(R.id.password)
        val checkbox=findViewById<CheckBox>(R.id.recuerdame)
        val button=findViewById<Button>(R.id.login)
        val buttonForgot=findViewById<Button>(R.id.forgotpassword)
        getCredentials() //Se invoca a la función que intentará iniciar sesión sin requerir datos.
        button.setOnClickListener {
            //Se obtienen los datos ingresados por el usuario
            val email = emailField.text.toString()
            val password = passwordField.text.toString()
            //Se guardan en SharedPreferences
            if(checkbox.isChecked()) {
                setCredentials(email, password)
            }
            //Se realiza el login
            login(email, password)

        }
        buttonForgot.setOnClickListener {
            intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }
    }

    fun login(email: String, password:String){
        if(Seguridad().loginCheck(email, password)) {
            //Solicitar chequeo a la API REST
            if (true){
                intent = Intent(this, Menu::class.java)
                startActivity(intent)
            }else genericError()
        }else genericError()
    }
    fun getCredentials(){
        //Obtiene las credenciales almacenadas. En caso de que no haya nada obtiene los strings vacíos.
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE) ?: return
        val emailSaved = sharedPref.getString(getString(R.string.email), "").toString()
        val passSaved = sharedPref.getString(getString(R.string.pass), "").toString()
        if(emailSaved != "" && passSaved != ""){
            login(emailSaved, passSaved)
        }
    }
    fun setCredentials(email: String, password:String){
        //Guarda las credenciales ingresadas. 
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString(getString(R.string.email), email)
            putString(getString(R.string.pass), password)
            apply()
        }
    }
    fun genericError(){
        Toast.makeText(this, "Usuario y/o contraseña incorrectos", Toast.LENGTH_LONG).show()
    }

}