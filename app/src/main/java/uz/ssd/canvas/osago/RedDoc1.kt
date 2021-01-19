package uz.ssd.canvas.osago

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.WebSettings
import kotlinx.android.synthetic.main.activity_main.*
import uz.ssd.canvas.Html
import uz.ssd.canvas.Html.DESKTOP_USER_AGENT
import uz.ssd.canvas.R
import uz.ssd.canvas.base.BaseActivity
import uz.ssd.canvas.osago.data.Policy

class RedDoc1 : BaseActivity() {

    override val layoutRes: Int = R.layout.activity_main
    private lateinit var policy: Policy

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val settings: WebSettings = webView.settings
        settings.userAgentString = DESKTOP_USER_AGENT

        btn.setOnClickListener { createWebPagePrint(webView) }
        btn2.setOnClickListener { download() }

        toolbar.setTitle("RED Doc 1")
        btn3.setOnClickListener {
            startActivity(Intent(this, RedDoc2::class.java))
        }
        btn3.text = "Osago Red Doc2"
    }

    private fun download() {
        policy = Policy(
                "30", "November", "20", "30", "November", "20",
                "Azizov Aziz", "Azizov Aziz", "Detail","detail","998999999999",
                "Cobalt", "2019", "123456", "123456", "AA534",
                "Insurer", "Tashkent","Gorkiy"
        )
        webView.loadDataWithBaseURL(
                "file:///android_asset/redstyle1.css",
                Html.redHtml1(policy),
                "text/html",
                "UTF-8",
                null
        )
    }

    /*private fun settingConfigure() {
          webView.settings.javaScriptEnabled = true
            webView.settings.loadWithOverviewMode = true
            webView.settings.useWideViewPort = true

            webView.webChromeClient = WebChromeClient()
            webView.webViewClient = WebViewClient()
            webView.settings.setSupportZoom(true)
            webView.settings.textZoom = 1

            webView.settings.builtInZoomControls = true
            webView.settings.displayZoomControls = false

            webView.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
            webView.isScrollbarFadingEnabled = false
            webView.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK

            webView.loadUrl("https://github.com/mr-shoxruxbek/TestCss/blob/main/pdf2html_1310/index.html")


        val error1= "2fYontnae0uGRMj+2lTSQQr2MD3ec+uAEeb0RcIjk0Pmp00tiJfCg5JLmbLxIwvvFQ5siHK9yjAgUVHoXbkJ68h0FrVD2AIQ"
        // Не удалось получить информацию о карте
        val error2= "2fYontnae0uGRMj+2lTSQWchwe510eOM5/DF2UaW4hFaPFd0/bPNqDKzVHTU6sw8d3CDihWguxS71kx/UVf0Ew=="
        // Не удалось зарегистрировать карту
        val error3= "CCBGeA8+wJ4HwkJDKd7BRjVsCiSaBgGJR0x8d1iJMVVnczPluEtaQA=="
        //Недостаточно средств

        Log.d("$$$$$",TripleDES.decrypt(error3))
    }*/

}