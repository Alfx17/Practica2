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

class sillaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_silla, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.videoSilla)
        val tituloSilla = view.findViewById<TextView>(R.id.tituloSilla)
        val reseñaSilla = view.findViewById<TextView>(R.id.ReseñaSilla)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.youtube.com/embed/zQtjSgfbiT0")

        val buttonSilla= view.findViewById<Button>(R.id.buttonSilla)
        buttonSilla.setOnClickListener {
            activity?.finish()
        }

        val prefs = requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE)
        val nightMode = prefs.getBoolean("night_mode", false)
        if (nightMode) {
            view.setBackgroundResource(R.drawable.nochefragment)

            tituloSilla.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasSilla))   // p.ej. white
            tituloSilla.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoSilla))

            reseñaSilla.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoSilla))

            buttonSilla.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoSilla))
            buttonSilla.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasSilla))

        } else {
            view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.FondoSilla))

            tituloSilla.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasSilla))
            tituloSilla.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoSilla))

            reseñaSilla.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoSilla))

            buttonSilla.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoSilla))
            buttonSilla.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasSilla))
        }
    }

}