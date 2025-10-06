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

class TenochFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tenoch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.videoTeotihuacan)
        val tituloTeotihuacan = view.findViewById<TextView>(R.id.tituloTeotihuacan)
        val reseñaTeotihuacan = view.findViewById<TextView>(R.id.ReseñaTeotihuacan)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.youtube.com/embed/lzvFTaegzlM")

        val buttonTeotihuacan= view.findViewById<Button>(R.id.buttonTeo)
        buttonTeotihuacan.setOnClickListener {
            activity?.finish()
        }

        val prefs = requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE)
        val nightMode = prefs.getBoolean("night_mode", false)
        if (nightMode) {
            view.setBackgroundResource(R.drawable.nochefragment)

            tituloTeotihuacan.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasTeotihuacan))   // p.ej. white
            tituloTeotihuacan.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoTeotihuacan))

            reseñaTeotihuacan.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoTeotihuacan))

            buttonTeotihuacan.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoTeotihuacan))
            buttonTeotihuacan.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasTeotihuacan))

        } else {
            view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.FondoTeotihuacan))

            tituloTeotihuacan.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasTeotihuacan))
            tituloTeotihuacan.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoTeotihuacan))

            reseñaTeotihuacan.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoTeotihuacan))

            buttonTeotihuacan.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoTeotihuacan))
            buttonTeotihuacan.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasTeotihuacan))
        }
    }

}