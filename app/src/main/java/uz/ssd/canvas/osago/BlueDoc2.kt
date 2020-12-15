package uz.ssd.canvas.osago

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.WebSettings
import kotlinx.android.synthetic.main.activity_main.*
import uz.ssd.canvas.Html.DESKTOP_USER_AGENT
import uz.ssd.canvas.Html.blueHtml2
import uz.ssd.canvas.R
import uz.ssd.canvas.base.BaseActivity
import uz.ssd.canvas.osago.data.Insurance

class BlueDoc2 : BaseActivity() {

    override val layoutRes: Int = R.layout.activity_main
    private lateinit var insurance: Insurance

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val settings: WebSettings = webView.settings
        settings.userAgentString = DESKTOP_USER_AGENT

        btn.setOnClickListener { createWebPagePrint(webView) }
        btn2.setOnClickListener { download() }
        btn3.setOnClickListener {
            startActivity(Intent(this, RedDoc1::class.java))
        }
        btn3.text = "Osago Red Doc"
    }

    private fun download() {
        insurance = Insurance(
                "1400000", "Bir million to`rt yuz ming",
                "1400000", "Bir million to`rt yuz ming",
                "1400000", "Bir million to`rt yuz ming",
                "1400000", "Bir million to`rt yuz ming",
                "Toshkent", "Yunusobod, Yakkasaroy, Sirg`ali, ...",
                "Toshkent 11, Navoiy ko`chasi 28, 9A uy",
                "AA", "3838605", "AB", "534",
                "Lorem ipsum", "Azizov Aziz", "30", "noyabr", "20", "16", "08"
        )
        webView.loadDataWithBaseURL(
                "file:///android_asset/bluestyle2.css",
                blueHtml2(insurance),
                "text/html",
                "UTF-8",
                null
        )
    }
}