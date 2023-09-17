package org.techtales.class26

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var btnGo: Button
    private lateinit var btnGoback: Button
    private lateinit var btnForward: Button
    private lateinit var edtUrl: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById(R.id.webview)
        btnGo = findViewById(R.id.btnGo)
        btnGoback = findViewById(R.id.btnGoBack)
        btnForward = findViewById(R.id.btnForward)
        edtUrl = findViewById(R.id.edturl3)

        var context = this

        webView.webViewClient = MyWebViewClient()

        btnGo.setOnClickListener({
            webView.loadUrl("https://" + edtUrl.text.toString())
        })

        btnGoback.setOnClickListener ({
            if (webView.canGoBack()) { // Check if there's history to go back
                webView.goBack() // Go back once
                edtUrl.setText(webView.url) // Update the EditText with the current URL
            } else {
                Toast.makeText(context, "No History Available", Toast.LENGTH_SHORT).show()
            }
        })

        btnForward.setOnClickListener({
            if (webView.canGoForward()) {
                webView.goForward()
                edtUrl.setText((webView.url))
            } else
                Toast.makeText(context, "No History Available", Toast.LENGTH_SHORT).show()
        })


    }

    class MyWebViewClient: WebViewClient() {
        @Suppress("OverridingDeprecatedMember")
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            if (url != null) {
                view?.loadUrl(url)
                return true
            }
            return false
        }



    }

}
