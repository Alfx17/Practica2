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

class cristoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cristo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.videoCristo)
        val tituloCristo = view.findViewById<TextView>(R.id.tituloCristo)
        val reseñaCristo = view.findViewById<TextView>(R.id.ReseñaCristo)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.youtube.com/embed/6RpOWBtZAk8")

        val buttonCristo = view.findViewById<Button>(R.id.buttonCristo)
        buttonCristo.setOnClickListener {
            activity?.finish()
        }

        val prefs = requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE)
        val nightMode = prefs.getBoolean("night_mode", false)
        if (nightMode) {
            view.setBackgroundResource(R.drawable.nochefragment)

            tituloCristo.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.letrasCristo
                )
            )
            tituloCristo.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.botonFondoCristo
                )
            )

            reseñaCristo.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.FondoCristo
                )
            )

            buttonCristo.backgroundTintList =
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.botonFondoCristo
                    )
                )
            buttonCristo.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.letrasCristo
                )
            )

        } else {
            view.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.FondoCristo
                )
            )

            tituloCristo.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.letrasCristo
                )
            )
            tituloCristo.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.botonFondoCristo
                )
            )

            reseñaCristo.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.letrasCristo
                )
            )

            buttonCristo.backgroundTintList =
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.botonFondoCristo
                    )
                )
            buttonCristo.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.letrasCristo
                )
            )
        }
    }


}
