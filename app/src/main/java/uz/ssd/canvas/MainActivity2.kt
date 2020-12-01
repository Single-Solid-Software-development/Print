package uz.ssd.canvas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.print.PrintAttributes
import android.print.PrintJob
import android.print.PrintManager
import android.webkit.CookieManager
import android.webkit.WebSettings
import android.webkit.WebStorage
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import uz.ssd.canvas.Html.DESKTOP_USER_AGENT

class MainActivity2 : AppCompatActivity() {

    private lateinit var policy: Policy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settings: WebSettings = webView.settings
        settings.userAgentString = DESKTOP_USER_AGENT
//        settings.cacheMode = WebSettings.LOAD_NO_CACHE

        btn.setOnClickListener { createWebPagePrint(webView) }
        btn2.setOnClickListener { download() }

        btn3.setOnClickListener {
            startActivity(Intent(this, MainActivity3::class.java))
        }
        showMessage(android.os.Build.VERSION.SDK + android.os.Build.DEVICE + android.os.Build.MODEL + android.os.Build.PRODUCT)
    }

    private fun createWebPagePrint(webView: WebView) {
        val printManager = getSystemService(Context.PRINT_SERVICE) as PrintManager
        val printAdapter = webView.createPrintDocumentAdapter("Canvas print Document")
        val builder = PrintAttributes.Builder()
        builder.setMediaSize(PrintAttributes.MediaSize.ISO_A5)
        builder.setColorMode(PrintAttributes.COLOR_MODE_MONOCHROME)
        builder.setMinMargins(PrintAttributes.Margins.NO_MARGINS)

        val printJob: PrintJob =
            printManager.print("Canvas print Document", printAdapter, builder.build())
        if (printJob.isCompleted) showMessage("print_complete")
        else if (printJob.isFailed) showMessage("print_failed")
    }

    private fun download() {
        policy = Policy(
            "30", "November", "20", "30", "November", "20",
            "Azizov Aziz", "Azizov Aziz", "998999999999",
            "Cobalt", "2019", "123456", "123456", "AA534",
            "Insurer", "Tashkent"
        )
//        clear()
        webView.loadDataWithBaseURL(
            "file:///android_asset/style2.css",
            Html.html2(policy),
            "text/html",
            "UTF-8",
            null
        )
//        webView.loadDataWithBaseURL(
//            htmlCss, htmlString, "text/html", "UTF-8", null
//        )
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

    private fun showMessage(message: String) =
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
}