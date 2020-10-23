package uz.ssd.canvas

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.print.PrintAttributes
import android.print.PrintJob
import android.print.PrintManager
import android.util.Log
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import kotlinx.android.synthetic.main.activity_main.*
import uz.ssd.canvas.Html.DESKTOP_USER_AGENT


private class JSInterface {
    @JavascriptInterface
    fun getString(str: String?) {
        Log.d("STRING", str ?: "Error")
    }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val settings: WebSettings = webView.settings
        settings.userAgentString = DESKTOP_USER_AGENT
        settings.cacheMode = WebSettings.LOAD_NO_CACHE
        settings.javaScriptEnabled = true
//        webView.addJavascriptInterface(JSInterface(), "api")

        btn.setOnClickListener { createWebPagePrint(webView) }
        btn2.setOnClickListener { download() }

//        showMessage(android.os.Build.VERSION.SDK + android.os.Build.DEVICE + android.os.Build.MODEL + android.os.Build.PRODUCT)
    }

    private fun createWebPagePrint(webView: WebView) {
        val printManager = getSystemService(Context.PRINT_SERVICE) as PrintManager
        val printAdapter = webView.createPrintDocumentAdapter("Canvas print Document")
        val builder = PrintAttributes.Builder()
        builder.setMediaSize(PrintAttributes.MediaSize.ISO_A5)
        builder.setColorMode(PrintAttributes.COLOR_MODE_MONOCHROME)
        builder.setMinMargins(PrintAttributes.Margins.NO_MARGINS)

        val printJob: PrintJob = printManager.print("Canvas print Document", printAdapter, builder.build())
        if (printJob.isCompleted) showMessage("print_complete")
        else if (printJob.isFailed) showMessage("print_failed")
    }

    private fun download() {
        clear()
        val CUSTOM_TAB_PACKAGE_NAME = "com.android.chrome";  // Change when in stable

//        webView.loadUrl("http://project.webforte.uz/pdf2html/")
//        webView.loadDataWithBaseURL(htmlCss, htmlString, "text/html", "UTF-8", null)
//        webView.loadDataWithBaseURL(htmlCss, htmlString, "text/html", "UTF-8", null)

        showMessage("Loading...)")
        val url = "http://project.webforte.uz/pdf2html/"
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        val coolorInt: Int = Color.parseColor("#FF0000") //red
        builder.setToolbarColor(coolorInt)

//        builder.setActionButton(bitmap, "Android", pendingIntent, true);



        customTabsIntent.launchUrl(this, Uri.parse(url))

//        webView.webViewClient = object: WebViewClient(){
//            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
//                view!!.loadUrl(htmlString)
//                return true
//            }
//
//
//        }

//        val downloadImageURL = webView.url

//        if (URLUtil.isValidUrl(downloadImageURL)) {

//            val request = DownloadManager.Request(Uri.parse(downloadImageURL))
//            request.allowScanningByMediaScanner()

//            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
//            val downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
//            downloadManager.enqueue(request)
//        } else {
//            showMessage("agr_empty_error_description")
//        }
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
    }*/

    private fun showMessage(message: String) =
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
}