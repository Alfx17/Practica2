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

class ilulissatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ilulissat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.videoIlulissat)
        val tituloIlulissat = view.findViewById<TextView>(R.id.tituloIlulissat)
        val reseñaIlulissat = view.findViewById<TextView>(R.id.ReseñaIlulissat)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.youtube.com/embed/I3lr4uU0QAo")

        val buttonIlulissat= view.findViewById<Button>(R.id.buttonIlulissat)
        buttonIlulissat.setOnClickListener {
            activity?.finish()
        }

        val prefs = requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE)
        val nightMode = prefs.getBoolean("night_mode", false)
        if (nightMode) {
            view.setBackgroundResource(R.drawable.nochefragment)

            tituloIlulissat.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasIlulissat))   // p.ej. white
            tituloIlulissat.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoIlulissat))

            reseñaIlulissat.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoIlulissat))

            buttonIlulissat.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoIlulissat))
            buttonIlulissat.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasIlulissat))

        } else {
            view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.FondoIlulissat))

            tituloIlulissat.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasIlulissat))
            tituloIlulissat.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoIlulissat))

            reseñaIlulissat.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoIlulissat))

            buttonIlulissat.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoIlulissat))
            buttonIlulissat.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasIlulissat))
        }
    }

}