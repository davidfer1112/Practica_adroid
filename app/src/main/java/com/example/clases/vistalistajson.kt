package com.example.clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream


class vistalistajson : AppCompatActivity() {

    val listaNombresPaises = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {

        val listaNombresPaises = mutableListOf<String>()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vistalistajson)

        val vistalistajson : ListView = findViewById(R.id.vistadelistajson)

        val json = JSONObject(loadJSONFromAssets())
        val paisesJSONarray = json.getJSONArray("paises")

        for (i in 0 until paisesJSONarray.length()) {
            val jsonObject = paisesJSONarray.getJSONObject(i)
            val capital = jsonObject.getString("nombre_pais")
            listaNombresPaises.add(capital)
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNombresPaises)
        vistalistajson.adapter = adapter


        vistalistajson.setOnItemClickListener { _, _, position, _ ->
            val nombrePaisSeleccionado = listaNombresPaises[position]
            val intent = Intent(this, detallepais::class.java)
            intent.putExtra("nombre_pais", nombrePaisSeleccionado)
            startActivity(intent)
        }

    }

    fun loadJSONFromAssets():String?{

        var json: String? = null

        try {
            val istream: InputStream = assets.open("paises.json")
            val size: Int  = istream.available()
            val buffer = ByteArray(size)
            istream.read(buffer)
            istream.close()
            json = String(buffer, Charsets.UTF_8)
        }catch (ex: IOException){
            ex.printStackTrace()
            return null
        }
        return json
    }


}
