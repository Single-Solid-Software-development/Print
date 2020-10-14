package uz.ssd.canvas

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.print.PrintAttributes
import android.print.PrintJob
import android.print.PrintManager
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import uz.ssd.canvas.Html.DESKTOP_USER_AGENT
import uz.ssd.canvas.Html.htmlCss
import uz.ssd.canvas.Html.htmlString

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        askRequest()
        val settings: WebSettings = webView.settings
        settings.userAgentString = DESKTOP_USER_AGENT
        settingConfigure()

        btn.setOnClickListener { createWebPagePrint(webView) }
        btn2.setOnClickListener { download() }

    }

    private fun createWebPagePrint(webView: WebView) {
        val printManager = getSystemService(Context.PRINT_SERVICE) as PrintManager
        val jobName = getString(R.string.app_name) + " Document"
        val printAdapter = webView.createPrintDocumentAdapter(jobName)
        val builder = PrintAttributes.Builder()
        builder.setMediaSize(PrintAttributes.MediaSize.ISO_A5)
        builder.setColorMode(PrintAttributes.COLOR_MODE_MONOCHROME)
        builder.setMinMargins(PrintAttributes.Margins.NO_MARGINS)

        val printJob: PrintJob = printManager.print(jobName, printAdapter, builder.build())
        if (printJob.isCompleted) showMessage("print_complete")
        else if (printJob.isFailed) showMessage("print_failed")
    }


    private fun download() {
        webView.loadDataWithBaseURL(
            htmlCss, htmlString, "text/html", "UTF-8", null
        )
    }

    private fun askRequest() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
        } else ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            PackageManager.PERMISSION_GRANTED
        )
    }

    private fun settingConfigure() {
        /*  webView.settings.javaScriptEnabled = true
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

            webView.loadUrl("https://github.com/mr-shoxruxbek/TestCss/blob/main/pdf2html_1310/index.html")*/
    }

    private fun showMessage(message: String) =
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
}