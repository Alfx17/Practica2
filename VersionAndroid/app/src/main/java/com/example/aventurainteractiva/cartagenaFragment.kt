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

class cartagenaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cartagena, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webView = view.findViewById<WebView>(R.id.videoCartagena)
        val buttonCartagena = view.findViewById<MaterialButton>(R.id.buttonCartagena)
        val tituloCartagena = view.findViewById<TextView>(R.id.tituloCartagena)
        val resenaCartagena = view.findViewById<TextView>(R.id.ReseñaCartagena) // usa el id tal cual está en tu XML

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.youtube.com/embed/F8ZWDKXuuzg")

        buttonCartagena.setOnClickListener {
            activity?.finish()
        }

        val prefs = requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE)
        val nightMode = prefs.getBoolean("night_mode", false)

        if (nightMode) {
            view.setBackgroundResource(R.drawable.nochefragment)

            tituloCartagena.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasCartagena))   // p.ej. white
            tituloCartagena.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoCartagena))

            resenaCartagena.setTextColor(ContextCompat.getColor(requireContext(), R.color.botonFondoCartagena))

            buttonCartagena.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoCartagena))
            buttonCartagena.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasCartagena))

        } else {
            view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.FondoCartagena))

            tituloCartagena.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasCartagena))
            tituloCartagena.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.botonFondoCartagena))

            resenaCartagena.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasCartagena))

            buttonCartagena.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.botonFondoCartagena))
            buttonCartagena.setTextColor(ContextCompat.getColor(requireContext(), R.color.letrasCartagena))
        }
    }
}
