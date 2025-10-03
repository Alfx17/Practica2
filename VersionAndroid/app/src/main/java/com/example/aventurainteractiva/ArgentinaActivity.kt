package com.example.aventurainteractiva

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ArgentinaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_argentina)

        val botonArgentina = findViewById<ImageButton>(R.id.cataratasB)
        botonArgentina.setOnClickListener {
            val intent = Intent(this, LugaresActivity::class.java)
            intent.putExtra("lugar", "CataratasArg")
            startActivity(intent)
        }

        val botonR = findViewById<Button>(R.id.buttonR)
        botonR.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}