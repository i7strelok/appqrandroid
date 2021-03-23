package com.example.appqr

import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Toolbar {
    fun show(activity:AppCompatActivity, title:String, upButton:Boolean) {
        val aux = activity.setSupportActionBar(activity.findViewById(R.id.toolbarGeneral))
        activity.supportActionBar?.title = title
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
        return aux
    }
}