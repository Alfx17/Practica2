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

class libertadFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_libertad, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.videoLibertad)
        val tituloLibertad = view.findViewById<TextView>(R.id.tituloLibertad)
        val reseñaLibertad = view.findViewById<TextView>(R.id.ReseñaLibertad)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.youtube.com/embed/d_-i8WMWv9g")

        val buttonLibertad= view.findViewById<Button>(R.id.buttonLibertad)
        buttonLibertad.setOnClickListener {
            activity?.finish()
        }

        val prefs = requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE)
        val nightMode = prefs.getBoolean("night_mode", false)
        if (nightMode) {
            view.setBackgroundResource(R.drawable.nochefragment)

            tituloLibertad.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasLibertad))   // p.ej. white
            tituloLibertad.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoLibertad))

            reseñaLibertad.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasLibertad))

            buttonLibertad.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.letrasLibertad))
            buttonLibertad.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoLibertad))

        } else {
            view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.FondoLibertad))

            tituloLibertad.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasLibertad))
            tituloLibertad.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoLibertad))

            reseñaLibertad.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasLibertad))

            buttonLibertad.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoLibertad))
            buttonLibertad.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasLibertad))
        }
    }

}