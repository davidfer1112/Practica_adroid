package com.example.clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actividadPrin();



    }

    fun actividadPrin(){

        //definir un boton y enlazarlo con un elemento
        val botnHola:Button = findViewById(R.id.boton_hola);
        val editnom:EditText = findViewById(R.id.edit1);
        val botonporcen:Button = findViewById(R.id.boton_cambio);
        val botonjuegoadi:Button = findViewById(R.id.boton_juego_adivinanza);
        val botonspinner:Button = findViewById(R.id.boton_spinner);
        val spinneredu:Spinner = findViewById(R.id.spinner_educacion);

        // Escucha al boton, es decir que cada vez que se presione el boton realiza lo que este adentro
        botnHola.setOnClickListener{
            var nombre:String = editnom.text.toString();
            mostrarToast(nombre);
        }

        //ejercicio 1 clase 3 Activities Intent
        botonporcen.setOnClickListener {
            val intent = Intent(this, viewActivity1::class.java)
            //ejercicio 2 clase 3 Activities Intent
            intent.putExtra("nombre",editnom.text.toString()) // enviar datos a otra actividad
            startActivity(intent);
        }

        botonjuegoadi.setOnClickListener {
            val intent = Intent(this,juego_adivinanzas::class.java)
            startActivity(intent)
        }

        botonspinner.setOnClickListener {
            val intent = Intent(this, spinner::class.java)

            val seleccion = spinneredu.selectedItem.toString()

//            Toast.makeText(applicationContext, "Nivel de educacion " + seleccion, Toast.LENGTH_LONG).show();
            intent.putExtra("nombre",editnom.text.toString())
            intent.putExtra("nivel_edu", seleccion)

            startActivity(intent)
        }


    }

    fun mostrarToast(entrada:String){
        Toast.makeText(applicationContext, "Hola " + entrada, Toast.LENGTH_LONG).show();
    }

}