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

class VallartaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vallarta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.videoVallarta)
        val tituloVallarta = view.findViewById<TextView>(R.id.tituloVallarta)
        val reseñaVallarta = view.findViewById<TextView>(R.id.ReseñaVallarta)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.youtube.com/embed/uyVWZ26JI2A")

        val buttonVallarta= view.findViewById<Button>(R.id.buttonVall)
        buttonVallarta.setOnClickListener {
            activity?.finish()
        }

        val prefs = requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE)
        val nightMode = prefs.getBoolean("night_mode", false)
        if (nightMode) {
            view.setBackgroundResource(R.drawable.nochefragment)

            tituloVallarta.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasVallarta))   // p.ej. white
            tituloVallarta.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoVallarta))

            reseñaVallarta.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoVallarta))

            buttonVallarta.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoVallarta))
            buttonVallarta.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasVallarta))

        } else {
            view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.FondoVallarta))

            tituloVallarta.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasVallarta))
            tituloVallarta.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoVallarta))

            reseñaVallarta.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoVallarta))

            buttonVallarta.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoVallarta))
            buttonVallarta.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasVallarta))
        }
    }

}
