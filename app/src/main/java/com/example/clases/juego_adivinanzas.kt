package com.example.clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class juego_adivinanzas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_adivinanzas)


        // instancia para la clase Random
        val random = Random(System.currentTimeMillis())

        //genera numero aleatorio entre
        val num_adivino:Int = random.nextInt(1001);

        juego(num_adivino);

    }


    fun juego(num_adivino:Int){

        val editadivina:EditText = findViewById(R.id.edit_adivinar)
        val botonadivina:Button = findViewById(R.id.boton_adivina)
        val textpista:TextView = findViewById(R.id.pista)
        var cant_intentos:TextView = findViewById(R.id.cantidad_intentos)
        var cantintentos:Int = 0;

        Toast.makeText(applicationContext,"" + num_adivino,Toast.LENGTH_LONG).show()




        botonadivina.setOnClickListener {

            var contenido_adivino:String = editadivina.text.toString();
            var numero_adivino:Int ?= null;

            try {
                numero_adivino = contenido_adivino.toInt();
            }catch (e: NumberFormatException){
                println(e);
            }

            if (numero_adivino != null){
                Toast.makeText(applicationContext, "$num_adivino",Toast.LENGTH_LONG).show()

                if( numero_adivino == num_adivino){
                    cantintentos ++;
                    textpista.setText("Adivinaste el numero")
                    cant_intentos.setText("Intentos: $cantintentos")
                }else if(numero_adivino < num_adivino){
                    textpista.setText("Estas por debajo del numero")
                    cantintentos ++;
                }else{
                    textpista.setText("Estas por Encima del numero")
                    cantintentos ++;
                }

            }else{
                Toast.makeText(applicationContext,"Ingresa un numero adivino" ,Toast.LENGTH_LONG).show()
            }
        }




    }



}