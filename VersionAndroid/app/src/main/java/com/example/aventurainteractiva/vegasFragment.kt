package com.example.aventurainteractiva

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import android.widget.Button

class vegasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vegas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.videoVegas)
        val tituloVegas = view.findViewById<TextView>(R.id.tituloVegas)
        val reseñaVegas = view.findViewById<TextView>(R.id.ReseñaVegas)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.youtube.com/embed/C-Du6LodmXY")

        val buttonVegas= view.findViewById<Button>(R.id.buttonVegas)
        buttonVegas.setOnClickListener {
            activity?.finish()
        }

        val prefs = requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE)
        val nightMode = prefs.getBoolean("night_mode", false)
        if (nightMode) {
            view.setBackgroundResource(R.drawable.nochefragment)

            tituloVegas.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasVegas))   // p.ej. white
            tituloVegas.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoVegas))

            reseñaVegas.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoVegas))

            buttonVegas.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoVegas))
            buttonVegas.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasVegas))

        } else {
            view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.FondoVegas))

            tituloVegas.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasVegas))
            tituloVegas.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoVegas))

            reseñaVegas.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasVegas))

            buttonVegas.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoVegas))
            buttonVegas.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasVegas))
        }
    }

}
