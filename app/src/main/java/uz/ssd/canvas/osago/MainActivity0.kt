package uz.ssd.canvas.osago

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.CookieManager
import android.webkit.WebSettings
import android.webkit.WebStorage
import android.webkit.WebView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import uz.ssd.canvas.Html.DESKTOP_USER_AGENT
import uz.ssd.canvas.Html.htmlCss
import uz.ssd.canvas.Html.htmlString
import uz.ssd.canvas.R
import uz.ssd.canvas.base.BaseActivity

class MainActivity0 : BaseActivity() {

    override val layoutRes: Int = R.layout.activity_main

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val settings: WebSettings = webView.settings
        settings.userAgentString = DESKTOP_USER_AGENT

        btn.setOnClickListener { createWebPagePrint(webView) }
        btn2.setOnClickListener { download() }
        btn3.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        btn3.text = "Osago Blue Doc2"
    }

    private fun download() {
        clear()
        webView.loadDataWithBaseURL(htmlCss, htmlString, "text/html", "UTF-8", null)
    }

    private fun clear() {
        WebStorage.getInstance().deleteAllData()

//        // Clear all the cookies
        CookieManager.getInstance().removeAllCookies(null)
        CookieManager.getInstance().flush()

        webView.clearCache(true)
        webView.clearFormData()
        webView.clearHistory()
        WebView(applicationContext).clearCache(true)
        webView.clearSslPreferences()
    }

}