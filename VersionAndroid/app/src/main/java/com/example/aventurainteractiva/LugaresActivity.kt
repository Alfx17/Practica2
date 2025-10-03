package com.example.aventurainteractiva

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LugaresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lugares)

        val lugar = intent.getStringExtra("lugar")

        val fragment = when(lugar){
            "Teotihuacan" -> TenochFragment()
            "Vallarta" -> VallartaFragment()
            "Silla" -> sillaFragment()
            "Mendenhall" -> mendenhallFragment()
            "Ilulissat" -> ilulissatFragment()
            "Niagara" -> niagaraFragment()
            "Toronto" -> torontoFragment()
            "Vegas" -> vegasFragment()
            "Libertad" -> libertadFragment()
            "Morrocoy" -> morrocoyFragment()
            "Cartagena" -> cartagenaFragment()
            "Machu" -> machuFragment()
            "CataratasArg" -> cataratasFragment()
            "Cristo" -> cristoFragment()
            else -> TenochFragment()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}