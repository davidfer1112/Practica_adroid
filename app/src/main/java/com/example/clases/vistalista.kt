package com.example.clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class vistalista : AppCompatActivity() {

    var arreglo = arrayOfNulls<String>(30)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vistalista)

        arrayinicial()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arreglo)

        val listView:ListView = findViewById(R.id.vistadelista)

        listView.adapter = adapter

    }

    fun arrayinicial(){

//        for(i in arreglo.indices){
//            arreglo[i] = if( i%2 == 0) "hola" else "chao"
//        }

        arreglo = resources.getStringArray(R.array.paisesLatam)

    }

}