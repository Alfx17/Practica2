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

class torontoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_toronto, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.videoToronto)
        val tituloToronto = view.findViewById<TextView>(R.id.tituloToronto)
        val reseñaToronto = view.findViewById<TextView>(R.id.ReseñaToronto)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.youtube.com/embed/F4IWaSQ31WE")

        val buttonToronto= view.findViewById<Button>(R.id.buttonToronto)
        buttonToronto.setOnClickListener {
            activity?.finish()
        }

        val prefs = requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE)
        val nightMode = prefs.getBoolean("night_mode", false)
        if (nightMode) {
            view.setBackgroundResource(R.drawable.nochefragment)

            tituloToronto.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasToronto))   // p.ej. white
            tituloToronto.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoToronto))

            reseñaToronto.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoToronto))

            buttonToronto.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoToronto))
            buttonToronto.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasToronto))

        } else {
            view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.FondoToronto))

            tituloToronto.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasToronto))
            tituloToronto.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoToronto))

            reseñaToronto.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoToronto))

            buttonToronto.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoToronto))
            buttonToronto.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasToronto))
        }
    }

}