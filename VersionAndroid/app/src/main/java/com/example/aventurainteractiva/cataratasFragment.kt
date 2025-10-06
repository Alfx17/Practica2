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

class cataratasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cataratas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.videoCataratas)
        val tituloCataratas = view.findViewById<TextView>(R.id.tituloCataratas)
        val reseñaCataratas = view.findViewById<TextView>(R.id.ReseñaCataratas)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.youtube.com/embed/yLNo6Og1EaQ")

        val buttonCataratas= view.findViewById<Button>(R.id.buttonCataratas)
        buttonCataratas.setOnClickListener {
            activity?.finish()
        }

        val prefs = requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE)
        val nightMode = prefs.getBoolean("night_mode", false)
        if (nightMode) {
            view.setBackgroundResource(R.drawable.nochefragment)

            tituloCataratas.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasCataratas))   // p.ej. white
            tituloCataratas.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoCataratas))

            reseñaCataratas.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoCataratas))

            buttonCataratas.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoCataratas))
            buttonCataratas.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasCataratas))

        } else {
            view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.FondoCataratas))

            tituloCataratas.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasCataratas))
            tituloCataratas.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoCataratas))

            reseñaCataratas.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoCataratas))

            buttonCataratas.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoCataratas))
            buttonCataratas.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasCataratas))
        }
    }

}