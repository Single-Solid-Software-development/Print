package uz.ssd.canvas

import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.encript.*
import java.io.UnsupportedEncodingException
import java.lang.StringBuilder
import java.security.GeneralSecurityException

class MainActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.encript)


        var key = if (PASSWORD_BASED_KEY) { //example for password based keys
            val salt = AesCbcWithIntegrity.saltString(AesCbcWithIntegrity.generateSalt())
            //If you generated the key from a password, you can store the salt and not the key.
            AesCbcWithIntegrity.generateKeyFromPassword(EXAMPLE_PASSWORD, salt)
        } else {
            AesCbcWithIntegrity.generateKey()
            //Note: If you are generating a random key, you'll probably be storing it somewhere
        }
        val keyStr = AesCbcWithIntegrity.keyString(key)

        key = AesCbcWithIntegrity.keys(keyStr)
        val maps = Prefs(this).mapToken
        val civ = AesCbcWithIntegrity.encrypt(etText.text.toString(), key)

        maps[etText.text.toString()] = civ
        Prefs(this).mapToken = maps

        val value = maps[etText.text.toString()]
        if (value != null) {
            val decryptedText = AesCbcWithIntegrity.decryptString(value, key)
            etText2.setText(decryptedText)
        } else etText2.setText("NUll")

        try {
            btn.setOnClickListener {
                val etText = etText.text.toString()
                val s = StringBuilder()
                etText.reversed().forEach {
                    s.append(it)
                    s.append(etText.random())
                }
                val bytes = Base64.encode(s.toString().toByteArray(), Base64.DEFAULT)
                val bytes2 = Base64.encode(bytes, Base64.DEFAULT)
                etText2.setText(String(bytes2))
            }

            btn2.setOnClickListener {
                val text = etText2.text.toString()
                val bytes2 = String(Base64.decode(text.toByteArray(), Base64.DEFAULT))
                val bytes = String(Base64.decode(bytes2, Base64.DEFAULT))
                val build = StringBuilder()
                for (x in bytes.indices) {
                    if (x % 2 == 0)
                        build.append(bytes[x])
                }


                etText.setText(build.reverse().toString())
            }


        } catch (e: GeneralSecurityException) {
            log("GeneralSecurityException", e)
        } catch (e: UnsupportedEncodingException) {
            log("UnsupportedEncodingException", e)
        }
    }

    private fun log(message: String, e: Any) {
        if (e is UnsupportedEncodingException) Log.e(TAG, message, e)
        else if (e is Int) Log.i(TAG, message)
    }


    companion object {
        const val TAG = "TestApp"
        private const val PASSWORD_BASED_KEY = true
        private const val EXAMPLE_PASSWORD =
            "always use passphrases for passwords wherever possible!"
    }
}