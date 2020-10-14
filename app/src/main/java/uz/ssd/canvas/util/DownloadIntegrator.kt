package uz.ssd.canvas.util

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.util.Log
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException
import java.net.URL


/**
 * Created by MrShoxruxbek on 21,May,2020
 */
class DownloadIntegrator constructor(private val context: Context) {
    val JSON_FILE_NAME = "style.css"

    private fun getJsonFromURL(): String {
        return URL("http://project.webforte.uz/pdf2html/style.css").readText()
    }

    fun readCategory(): String {
        val json = getJsonFromURL()
        val jsonString: String? = try {
            val inputStream = context.assets.open(JSON_FILE_NAME)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()


            Log.d("$$$$$$$$$$$$$", String(buffer, Charsets.UTF_8))

            return json
        } catch (e: IOException) {
            null
        }

        return ""
    }

    fun write() {
        val f = context.getFileStreamPath("styles123.css")
        val fw = FileWriter(f)
        fw.write("word") // write string

        fw.close()
    }

    fun read() {
        val f = context.getFileStreamPath("styles123.css")
        val fr = FileReader(f)
        val chr = fr.read() // read char

        fr.close()
    }

    private fun download(context: Context) {
        val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val uri =
            Uri.parse("https://doc-0o-5o-docs.googleusercontent.com/docs/securesc/2bm3ukl625om1o68ersu7sb40e76vm7l/hhc3f1piv658uqqrmoa9350doob2huhg/1602655950000/13333986503449021551/13333986503449021551/1g_Bn-G_qfMNMzktue_saesam94OWGliK?e=download&authuser=0&nonce=f0gjrba8r05gs&user=13333986503449021551&hash=c6e6ja5dt0603efbn0dkjrn8aa9sk493")
        val request = DownloadManager.Request(uri)
        try {
            val path = context.filesDir.absolutePath + "/DownloadTestFolder"
            request.setDestinationInExternalPublicDir(path, "/")
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            val reference = downloadManager.enqueue(request)

        } catch (e: Exception) {
            Log.d("$$$$$", e.message ?: "000000000")
        }
    }
}
