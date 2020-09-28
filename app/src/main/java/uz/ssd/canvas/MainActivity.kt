package uz.ssd.canvas

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfRenderer
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED) {
            create()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                PackageManager.PERMISSION_GRANTED
            )
        }

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