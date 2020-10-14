package uz.ssd.canvas

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.os.Environment
import android.print.PrintAttributes
import android.print.PrintJob
import android.print.PrintManager
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import uz.ssd.canvas.Html.DESKTOP_USER_AGENT
import uz.ssd.canvas.Html.htmlCss
import uz.ssd.canvas.Html.htmlString
import uz.ssd.canvas.util.DownloadIntegrator
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


@Suppress("DEPRECATION")
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
//        builder.setResolution(Resolution("zoom", PRINT_SERVICE, 600, 600))

        val printJob: PrintJob = printManager.print(jobName, printAdapter, builder.build())
        if (printJob.isCompleted) showMessage("print_complete")
        else if (printJob.isFailed) showMessage("print_failed")
    }


    private fun download() {
        GlobalScope.launch {
            val json = DownloadIntegrator(applicationContext).readCategory()
            Log.d("$$$$", json)
        }

        webView.loadDataWithBaseURL(
            htmlCss, htmlString, "text/html", "UTF-8", null
        )
    }

    private fun askRequest() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) create()
        else ActivityCompat.requestPermissions(
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

    private fun create() {
        val pdf = PdfDocument()
        val paint = Paint()

        val pageInfo = PdfDocument.PageInfo.Builder(418, 598, 1).create()
        val page1 = pdf.startPage(pageInfo)

        val canvas = page1.canvas
        paint.textSize = 7f
        canvas.drawText("Hello", 36.72f, 62f, paint)
        pdf.finishPage(page1)

        val file = File(Environment.getExternalStorageDirectory().absolutePath, "/Hello.pdf")

        /*folder.mkdirs()

        val file = File(folder, "Hello.pdf")
        if (file.exists ()) file.delete ()
        file.createNewFile()*/
        try {
            pdf.writeTo(FileOutputStream(file))
        } catch (e: IOException) {
            e.printStackTrace()
        }
        showMessage("DONE")
        pdf.close()
    }

    private fun showMessage(message: String) =
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
}