package com.example.aventurainteractiva

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Botón para Alaska
        val alaskaB = findViewById<Button>(R.id.Alaska)
        alaskaB.setOnClickListener {
            val intent = Intent(this, AlaskaActivity::class.java)
            startActivity(intent)
        }
        //Botón para Groenlandia
        val groenlandiaB = findViewById<Button>(R.id.Groenlandia)
        groenlandiaB.setOnClickListener {
            val intent = Intent(this, GroenlandiaActivity::class.java)
            startActivity(intent)
        }
        //Botón para Canada
        val canadaB = findViewById<Button>(R.id.Canada)
        canadaB.setOnClickListener {
            val intent = Intent(this, CanadaActivity::class.java)
            startActivity(intent)
        }
        //Botón para EUA
        val EUAB = findViewById<Button>(R.id.EUA)
        EUAB.setOnClickListener {
            val intent = Intent(this, EUAActivity::class.java)
            startActivity(intent)
        }
        //Botón para México
        val mexicoB = findViewById<Button>(R.id.Mexico)
        mexicoB.setOnClickListener {
            val intent = Intent(this, MexicoActivity::class.java)
            startActivity(intent)
        }
        //Botón para Venezuela
        val venezuelaB = findViewById<Button>(R.id.Venezuela)
        venezuelaB.setOnClickListener {
            val intent = Intent(this, VenezuelaActivity::class.java)
            startActivity(intent)
        }
        //Botón para Colombia
        val colombiaB = findViewById<Button>(R.id.Colombia)
        colombiaB.setOnClickListener {
            val intent = Intent(this, ColombiaActivity::class.java)
            startActivity(intent)
        }
        //Botón para Perú
        val peruB = findViewById<Button>(R.id.Peru)
        peruB.setOnClickListener {
            val intent = Intent(this, PeruActivity::class.java)
            startActivity(intent)
        }
        //Botón para Brasil
        val brasilB = findViewById<Button>(R.id.Brasil)
        brasilB.setOnClickListener {
            val intent = Intent(this, BrasilActivity::class.java)
            startActivity(intent)
        }
        //Botón para Argentina
        val argentinaB = findViewById<Button>(R.id.Argentina)
        argentinaB.setOnClickListener {
            val intent = Intent(this, ArgentinaActivity::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}