package com.example.clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.NumberFormatException

class viewActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view1)

        val  nombre =  intent.getStringExtra("nombre")
        Toast.makeText(applicationContext, "Hola " + nombre + " ya puedes calcular el porcentaje", Toast.LENGTH_LONG).show();


        //llamada de la funcion
        calcular();


    }

    fun calcular(){

        //declaracion de los objetos del layout
        val botonporcen:Button = findViewById(R.id.botonPorcentaje);
        val editporcen:EditText = findViewById(R.id.editporcentaje);
        val editnumero:EditText = findViewById(R.id.editnumero);
        val textresul:TextView = findViewById(R.id.textviewresultado);

        //escucha el boton
        botonporcen.setOnClickListener{

            var textnumero:String = editnumero.text.toString(); // guardar el texto del edit Text numero
            var textporcen:String = editporcen.text.toString(); // guardar el texto del edit Text procentaje



            var numero:Int ?= null; // definir variable donde se va a guardar el numero
            var porcentaje:Int ?= null; // definir variavle donde se va a guardar el porcentaje

            try {
                numero = textnumero.toInt(); // castear el texto a numero
                porcentaje  = textporcen.toInt(); // castear el texto a numero
            }catch (e: NumberFormatException){
                println(e); // imprime el error
            }

            if(numero != null && porcentaje != null ){ // si el numero no es nulo
                if(porcentaje > 0 && porcentaje <= 100){
                    var resultado:Float = (porcentaje.toFloat()/100) * numero;
                    textresul.setText("El resultado es: $resultado");
                }else{
                    Toast.makeText(applicationContext, "El porcentaje tiene que ser un numero entre 1 y 100", Toast.LENGTH_LONG).show();
                    textresul.setText("");
                }
            }else if(numero == null){
                Toast.makeText(applicationContext, "Ingrese el numero", Toast.LENGTH_LONG).show();
                textresul.setText("");
            }else{
                Toast.makeText(applicationContext,"Ingrese el porcentaje", Toast.LENGTH_LONG).show();
                textresul.setText("");
            }

        }

    }
}