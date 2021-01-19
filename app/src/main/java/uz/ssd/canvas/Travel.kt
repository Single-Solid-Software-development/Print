package uz.ssd.canvas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.print.PrintAttributes
import android.webkit.WebSettings
import kotlinx.android.synthetic.main.activity_main.*
import uz.ssd.canvas.Html.DESKTOP_USER_AGENT
import uz.ssd.canvas.Html.kaskoHtml1
import uz.ssd.canvas.Html.travel
import uz.ssd.canvas.base.BaseActivity
import uz.ssd.canvas.kasko.data.KaskoData
import uz.ssd.canvas.osago.BlueDoc1

class Travel : BaseActivity() {

    override val layoutRes: Int = R.layout.activity_main

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val settings: WebSettings = webView.settings
        settings.userAgentString = DESKTOP_USER_AGENT
        btn3.setOnClickListener {
            startActivity(Intent(this, BlueDoc1::class.java))
        }
        toolbar.title = "Travel"

        btn.setOnClickListener { createWebPagePrint(webView) }
        btn2.setOnClickListener { download() }
    }

    private fun download() {
        mediaType = PrintAttributes.MediaSize.ISO_A4
        webView.loadDataWithBaseURL(
                "file:///android_asset/travel.css",
            travel(),
                "text/html",
                "UTF-8",
                null
        )
    }
}