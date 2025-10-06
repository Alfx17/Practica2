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

class niagaraFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_niagara, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.videoNiagara)
        val tituloNiagara = view.findViewById<TextView>(R.id.tituloNiagara)
        val reseñaNiagara = view.findViewById<TextView>(R.id.ReseñaNiagara)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.youtube.com/embed/ltALiwZFom0")

        val buttonNiagara= view.findViewById<Button>(R.id.buttonNiagara)
        buttonNiagara.setOnClickListener {
            activity?.finish()
        }

        val prefs = requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE)
        val nightMode = prefs.getBoolean("night_mode", false)
        if (nightMode) {
            view.setBackgroundResource(R.drawable.nochefragment)

            tituloNiagara.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasNiagara))   // p.ej. white
            tituloNiagara.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoNiagara))

            reseñaNiagara.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoNiagara))

            buttonNiagara.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoNiagara))
            buttonNiagara.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasNiagara))

        } else {
            view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.FondoNiagara))

            tituloNiagara.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasNiagara))
            tituloNiagara.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoNiagara))

            reseñaNiagara.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoNiagara))

            buttonNiagara.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoNiagara))
            buttonNiagara.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasNiagara))
        }
    }

}