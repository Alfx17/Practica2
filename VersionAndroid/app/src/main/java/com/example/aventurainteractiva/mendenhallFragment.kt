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

class mendenhallFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mendenhall, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.videoMendenhall)
        val tituloMendenhall = view.findViewById<TextView>(R.id.tituloMendenhall)
        val reseñaMendenhall = view.findViewById<TextView>(R.id.ReseñaMendenhall)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.youtube.com/embed/SihnVbeAXAA")

        val buttonMendenhall= view.findViewById<Button>(R.id.buttonMendenhall)
        buttonMendenhall.setOnClickListener {
            activity?.finish()
        }

        val prefs = requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE)
        val nightMode = prefs.getBoolean("night_mode", false)
        if (nightMode) {
            view.setBackgroundResource(R.drawable.nochefragment)

            tituloMendenhall.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasMendenhall))   // p.ej. white
            tituloMendenhall.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoMendenhall))

            reseñaMendenhall.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoMendenhall))

            buttonMendenhall.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoMendenhall))
            buttonMendenhall.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasMendenhall))

        } else {
            view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.FondoMendenhall))

            tituloMendenhall.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasMendenhall))
            tituloMendenhall.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoMendenhall))

            reseñaMendenhall.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoMendenhall))

            buttonMendenhall.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoMendenhall))
            buttonMendenhall.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasMendenhall))
        }
    }

}
