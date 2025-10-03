package com.example.aventurainteractiva

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EUAActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_euaactivity)

        val botonEUA1 = findViewById<ImageButton>(R.id.vegasB)
        botonEUA1.setOnClickListener {
            val intent = Intent(this, LugaresActivity::class.java)
            intent.putExtra("lugar", "Vegas")
            startActivity(intent)
        }

        val botonEUA2 = findViewById<ImageButton>(R.id.libertadB)
        botonEUA2.setOnClickListener {
            val intent = Intent(this, LugaresActivity::class.java)
            intent.putExtra("lugar", "Libertad")
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