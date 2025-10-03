package com.example.aventurainteractiva

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button


class mendenhallFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mendenhall, container, false)
        val webView = view.findViewById<WebView>(R.id.videoMendenhall)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.youtube.com/embed/SihnVbeAXAA")

        val buttonMendenhall= view.findViewById<Button>(R.id.buttonMendenhall)
        buttonMendenhall.setOnClickListener {
            activity?.finish()
        }

        return view
    }
}
