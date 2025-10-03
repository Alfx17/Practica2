package com.example.aventurainteractiva

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class sillaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_silla, container, false)
        val webView = view.findViewById<WebView>(R.id.videoSilla)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.youtube.com/embed/zQtjSgfbiT0")

        val buttonSilla= view.findViewById<Button>(R.id.buttonSilla)
        buttonSilla.setOnClickListener {
            activity?.finish()
        }

        return view
    }

}