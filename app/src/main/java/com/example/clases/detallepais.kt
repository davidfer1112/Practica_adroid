package com.example.clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class detallepais : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detallepais)

        // Obtener referencias a los TextView en el layout
        val textViewNombrePais = findViewById<TextView>(R.id.textViewNombrePais)
        val textViewCapital = findViewById<TextView>(R.id.textViewCapital)
        val textViewNombreIngles = findViewById<TextView>(R.id.textViewNombreIngles)
        val textViewSigla = findViewById<TextView>(R.id.textViewSigla)

        val nombrepais = intent.getStringExtra("nombre_pais")

        val json = JSONObject(loadJSONFromAssets())
        val paisesJSONArray = json.getJSONArray("paises")

        var detallepais: JSONObject ?= null;

        for(i in 0 until  paisesJSONArray.length()){
            val jsonObject = paisesJSONArray.getJSONObject(i)
            val capital :String = jsonObject.getString("nombre_pais")
            if(capital == nombrepais){
                detallepais = jsonObject
                break
            }
        }



        // Obtener información del país desde el JSONObject 'detallepais'
        val nombrePais = detallepais?.getString("nombre_pais") ?: ""
        val capital = detallepais?.getString("capital") ?: ""
        val nombreIngles = detallepais?.getString("nombre_pais_int") ?: ""
        val sigla = detallepais?.getString("sigla") ?: ""

        // Establecer el texto en los TextView
        textViewNombrePais.text = "Nombre del País: " + nombrePais
        textViewCapital.text = "Capital: " + capital
        textViewNombreIngles.text = "Nombre en Inglés: " + nombreIngles
        textViewSigla.text = "Sigla: " + sigla



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