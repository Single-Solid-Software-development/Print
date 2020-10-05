package uz.ssd.canvas

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.os.Environment
import android.print.PdfPrint
import android.print.PrintAttributes
import android.print.PrintAttributes.Resolution
import android.print.PrintJob
import android.print.PrintManager
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            create()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                PackageManager.PERMISSION_GRANTED
            )
        }

        val DESKTOP_USER_AGENT =
            "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2049.0 Safari/537.36"
        val MOBILE_USER_AGENT =
            "Mozilla/5.0 (Linux; U; Android 4.4; en-us; Nexus 4 Build/JOP24G) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30"

        //Choose Mobile/Desktop client.
        val settings: WebSettings = webView.settings
        settings.userAgentString = DESKTOP_USER_AGENT

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
//
        val inputStream: InputStream = assets.open("index.html")
        val size: Int = inputStream.available()

        val buffer = ByteArray(size)

        inputStream.read(buffer)
        inputStream.close()
        val day = 10
//        var htmlString = String(buffer)

//        webView.loadDataWithBaseURL("file:///android_asset/", htmlData, "text/html", "UTF-8", null)
        val htmlString = """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Pdf to Html</title>
</head>
<body>
    <div class="wrapper">
        <form action="">
            <div class="container">
                <div class="period-dates">
                    <div class="period-from">
                        <input type="text" name="from-day" class="day" value="$day">
                        <input type="text" name="from-month" class="month" value="$day">
                        <input type="text" name="from-year" class="year">
                    </div>
                    <div class="period-to">
                        <input type="text" name="to-day" class="day">
                        <input type="text" name="to-month" class="month">
                        <input type="text" name="to-year" class="year">
                    </div>
                </div>
                <div class="insurance-firm">
                    <input type="text" name="insurance-subject" class="full-width">
                </div>
                <div class="insurance-object">
                    <input type="text" name="insurance-object" class="full-width">
                </div>
                <div class="subject-phone" >
                    <input type="tel" name="subject-phone" maxlength="12">
                </div>
                <div class="transport-info">
                    <input type="text" name="mark_and_model" class="mark">
                    <input type="text" name="issue-year" class="issue-year">
                    <input type="text" name="generator-number" class="generator-number">
                    <input type="text" name="carcase-number" class="carcase-number">
                    <input type="text" name="government-number" class="governtment-number">
                </div>
                <div class="subject-profession" >
                    <input type="text" name="subject-profession">
                </div>
                <div class="transport-users">
                    <input type="text" name="transport-users">
                </div>
                <div class="users-can-drive">
                    <div class="user-item">
                        <div class="fio">
                            <input type="text" name="user[0][first-name]">
                            <input type="text" name="user[0][last-name]">
                            <input type="text" name="user[0][third-name]">   
                        </div>
                        <div class="driver-info">
                            <input type="text" name="user[0][serial]" class="serial">
                            <input type="text" name="user[0][number]" class="number">
                        </div>
                        <div class="relationship">
                            <input type="text" name="user[0][relationship]">
                        </div>
                    </div>
                    <div class="user-item">
                        <div class="fio">
                            <input type="text" name="user[1][first-name]">
                            <input type="text" name="user[1][last-name]">
                            <input type="text" name="user[1][third-name]">   
                        </div>
                        <div class="driver-info">
                            <input type="text" name="user[1][serial]" class="serial">
                            <input type="text" name="user[1][number]" class="number">
                        </div>
                        <div class="relationship">
                            <input type="text" name="user[1][relationship]">
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>
</html>"""
        val htmlData =
            "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />" + htmlString
        webView.loadDataWithBaseURL("file:///android_asset/style.css", htmlString, "text/html", "UTF-8", null)
//        webView.loadData(htmlData, "text/html; charset=utf-8", null)
        btn.setOnClickListener {
            createWebPagePrint(webView)
//            createWebPrintJob(webView)
        }
//        File(Environment.getExternalStorageState(), "fileName")
    }

    private fun createWebPrintJob(webView: WebView) {
        val jobName = getString(R.string.app_name) + " Document"
        val attributes = PrintAttributes.Builder()
            .setMediaSize(PrintAttributes.MediaSize.ISO_A5)
            .setResolution(Resolution("pdf", "pdf", 600, 600))
            .setMinMargins(PrintAttributes.Margins.NO_MARGINS).build()
        val path =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM + "/PDFTest/")
        val pdfPrint = PdfPrint(attributes)
        pdfPrint.print(
            webView.createPrintDocumentAdapter(jobName),
            path,
            "output_" + System.currentTimeMillis() + ".pdf"
        )
    }

    fun createWebPagePrint(webView: WebView) {
        /*if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT)
            return;*/
        val printManager = getSystemService(Context.PRINT_SERVICE) as PrintManager
        val printAdapter = webView.createPrintDocumentAdapter()
        val jobName = getString(R.string.app_name) + " Document"
        val builder = PrintAttributes.Builder()
        builder.setMediaSize(PrintAttributes.MediaSize.ISO_A5)
        val printJob: PrintJob = printManager.print(jobName, printAdapter, builder.build())
        if (printJob.isCompleted) {
            Toast.makeText(applicationContext, "print_complete", Toast.LENGTH_LONG)
                .show()
        } else if (printJob.isFailed) {
            Toast.makeText(applicationContext, "print_failed", Toast.LENGTH_LONG).show()
        }
        // Save the job object for later status checking
    }

    fun create() {
        val pdf = PdfDocument()
        val paint = Paint()


        val pageInfo = PdfDocument.PageInfo.Builder(418, 598, 1).create()
        val page1 = pdf.startPage(pageInfo)

        val canvas = page1.canvas
        paint.textSize = 7f
        canvas.drawText("Hello", 36.72f, 62f, paint)
        pdf.finishPage(page1)


        val file = File(Environment.getExternalStorageDirectory().absolutePath, "/Hello.pdf")

//        folder.mkdirs()
//
//        val file = File(folder, "Hello.pdf")
//        if (file.exists ()) file.delete ()
//        file.createNewFile()
        try {
            pdf.writeTo(FileOutputStream(file))
        } catch (e: IOException) {
            e.printStackTrace()
        }
        Toast.makeText(this, "DONE", Toast.LENGTH_SHORT).show()
        pdf.close()
    }

}