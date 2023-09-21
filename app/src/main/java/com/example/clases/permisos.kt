package com.example.clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class permisos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permisos)

        val botonimgcontactos:ImageButton = findViewById(R.id.botonimg_contactos)


        botonimgcontactos.setOnClickListener {

            val intent = Intent (this, vistapermisocontactos::class.java)

            startActivity(intent)
        }


    }
}