package com.example.aventurainteractiva

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.ImageButton
import android.content.Intent
class BrasilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_brasil)

        val botonCristo = findViewById<ImageButton>(R.id.cristoB)
        botonCristo.setOnClickListener {
            val intent = Intent(this, LugaresActivity::class.java)
            intent.putExtra("lugar", "Cristo")
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