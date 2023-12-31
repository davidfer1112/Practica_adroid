package com.example.clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class vistalista : AppCompatActivity() {

    var arreglo = arrayOfNulls<String>(30)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vistalista)

        arrayinicial()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arreglo)

        val listView:ListView = findViewById(R.id.vistadelista)

        listView.adapter = adapter

        listView.setOnItemClickListener(AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedElement = arreglo[position]
            Toast.makeText(this@vistalista, selectedElement, Toast.LENGTH_LONG).show()
        })

    }

    fun arrayinicial(){
        arreglo = resources.getStringArray(R.array.paisesLatam)

    }

}