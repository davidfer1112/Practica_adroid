package com.example.clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.NumberFormatException

class viewActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view1)

        calcular();


    }

    fun calcular(){

        val botonporcen:Button = findViewById(R.id.botonPorcentaje);
        val editporcen:EditText = findViewById(R.id.editporcentaje);
        val editnumero:EditText = findViewById(R.id.editnumero);






        botonporcen.setOnClickListener{

            var textnumero:String = editnumero.text.toString()
            var numero:Int ?= null;

            try {
                numero= textnumero.toInt();
            }catch (e: NumberFormatException){
                println(e);
            }

            if(numero != null){
                val resul = 2 + numero;
                Toast.makeText(applicationContext, "Hola $resul", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(applicationContext, "Hola :(" + textnumero, Toast.LENGTH_LONG).show();
            }

        }

    }
}