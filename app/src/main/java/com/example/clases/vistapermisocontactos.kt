package com.example.clases

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class vistapermisocontactos : AppCompatActivity() {

    private val CONTACTS_PERMISSION_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vistapermisocontactos)

        val textveri: TextView = findViewById(R.id.textoverfi)
        val botonabrircon:Button = findViewById(R.id.boton_abrircontactos)

        // Verificar si ya se concedió el permiso
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
            == PackageManager.PERMISSION_GRANTED) {
            textveri.text = "Permiso concedido"
            textveri.setTextColor(ContextCompat.getColor(this, R.color.verde))
            Toast.makeText(applicationContext,"Permiso concedido", Toast.LENGTH_LONG).show();
        } else {
            // Si el permiso no se concedió, solicítalo
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_CONTACTS),
                CONTACTS_PERMISSION_CODE
            )
        }

        botonabrircon.setOnClickListener {

            val intent  = Intent(this, ContactsAdapter::class.java)

            startActivity(intent)
        }

    }

    // Este método se llama cuando el usuario responde a la solicitud de permisos
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == CONTACTS_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido
                val textveri: TextView = findViewById(R.id.textoverfi)
                textveri.text = "Permiso concedido"
                textveri.setTextColor(ContextCompat.getColor(this, R.color.verde))
                Toast.makeText(applicationContext,"Permiso concedido", Toast.LENGTH_LONG).show();
            } else {
                // Permiso denegado
                val textveri: TextView = findViewById(R.id.textoverfi)
                textveri.text = "Permiso denegado"
                textveri.setTextColor(ContextCompat.getColor(this, R.color.rojo))
                Toast.makeText(applicationContext,"Permiso denegado", Toast.LENGTH_LONG).show();
            }
        }
    }
}
