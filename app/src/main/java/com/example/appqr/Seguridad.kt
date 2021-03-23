package com.example.appqr

class Seguridad {
    fun passwordCheck(password:String):Boolean{
        return password.isNotEmpty()
    }
    fun emailCheck(email: String):Boolean{
        return email.isNotEmpty()
    }
    fun loginCheck(email: String, password:String):Boolean{
        return emailCheck(email) && passwordCheck(password)
    }
}