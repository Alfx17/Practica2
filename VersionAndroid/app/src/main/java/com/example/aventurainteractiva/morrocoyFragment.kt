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

class morrocoyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_morrocoy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.videoMorrocoy)
        val tituloMorrocoy = view.findViewById<TextView>(R.id.tituloMorrocoy)
        val reseñaMorrocoy = view.findViewById<TextView>(R.id.ReseñaMorrocoy)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.youtube.com/embed/XDMJLGXS16k")

        val buttonMorrocoy= view.findViewById<Button>(R.id.buttonMorrocoy)
        buttonMorrocoy.setOnClickListener {
            activity?.finish()
        }

        val prefs = requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE)
        val nightMode = prefs.getBoolean("night_mode", false)
        if (nightMode) {
            view.setBackgroundResource(R.drawable.nochefragment)

            tituloMorrocoy.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasMorrocoy))   // p.ej. white
            tituloMorrocoy.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoMorrocoy))

            reseñaMorrocoy.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasMorrocoy))

            buttonMorrocoy.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoMorrocoy))
            buttonMorrocoy.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasMorrocoy))

        } else {
            view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.FondoMorrocoy))

            tituloMorrocoy.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasMorrocoy))
            tituloMorrocoy.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoMorrocoy))

            reseñaMorrocoy.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasMorrocoy))

            buttonMorrocoy.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoMorrocoy))
            buttonMorrocoy.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasMorrocoy))
        }
    }

}