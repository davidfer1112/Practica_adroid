package com.example.clases


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class vistaweb : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vistaweb)

        val webView: WebView = findViewById(R.id.vistaweb)
        webView.loadUrl("https://www.javeriana.edu.co/inicio")
    }
}