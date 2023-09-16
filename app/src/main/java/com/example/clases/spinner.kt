package com.example.clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class spinner : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        llegada()

    }

    fun llegada(){

        val nivedu = intent.getStringExtra("nivel_edu")
        val nombre = intent.getStringExtra("nombre")

        val textedu:TextView = findViewById(R.id.text_nivel_edu)

        if(nivedu == "Selecciona una opcion"){
            textedu.setText("Tu "+nombre+" no has seleccionado un nivel educativo valido")
        }else{
            textedu.setText("Tu "+nombre+" tienes un nivel de educacion de " + nivedu )
        }


    }
}