package uz.ssd.canvas.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.print.PrintAttributes
import android.print.PrintJob
import android.print.PrintManager
import android.util.Log
import android.webkit.CookieManager
import android.webkit.WebStorage
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import uz.ssd.canvas.osago.MainActivity0
import uz.ssd.canvas.z_test.TripleDES

abstract class BaseActivity : AppCompatActivity() {

    abstract val layoutRes: Int
    protected var mediaType: PrintAttributes.MediaSize? = PrintAttributes.MediaSize.ISO_A5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        showMessage(android.os.Build.DEVICE + android.os.Build.MODEL + android.os.Build.PRODUCT)
    }

    protected fun createWebPagePrint(webView: WebView) {
        val printManager = getSystemService(Context.PRINT_SERVICE) as PrintManager
        val printAdapter = webView.createPrintDocumentAdapter("Canvas print Document")
        val builder = PrintAttributes.Builder()
        builder.setMediaSize(mediaType!!)
        builder.setColorMode(PrintAttributes.COLOR_MODE_MONOCHROME)
        builder.setMinMargins(PrintAttributes.Margins.NO_MARGINS)

        val printJob: PrintJob = printManager.print("Canvas print Document", printAdapter, builder.build())
        if (printJob.isCompleted) showMessage("print_complete")
        else if (printJob.isFailed) showMessage("print_failed")
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

    protected fun showMessage(message: String) =
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()

//    protected fun startActivity(activity: Class){
//        startActivity(Intent(this, activity))
//    }
    protected fun checkMessage() {
        val error1 = "2fYontnae0uGRMj+2lTSQQr2MD3ec+uAEeb0RcIjk0Pmp00tiJfCg5JLmbLxIwvvFQ5siHK9yjAgUVHoXbkJ68h0FrVD2AIQ"
        // Не удалось получить информацию о карте
        val error2 = "2fYontnae0uGRMj+2lTSQWchwe510eOM5/DF2UaW4hFaPFd0/bPNqDKzVHTU6sw8d3CDihWguxS71kx/UVf0Ew=="
        // Не удалось зарегистрировать карту
        val error3 = "CCBGeA8+wJ4HwkJDKd7BRjVsCiSaBgGJR0x8d1iJMVVnczPluEtaQA=="
        //Недостаточно средств

        Log.d("$$$$$", TripleDES.decrypt(error3))
    }
}