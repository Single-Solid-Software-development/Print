package uz.ssd.canvas

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.encript.*
import uz.ssd.canvas.AesCbcWithIntegrity.SecretKeys
import java.io.UnsupportedEncodingException
import java.security.GeneralSecurityException
import kotlin.random.Random.Default.Companion

class MainActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.encript)

        try {
            var key: SecretKeys?
            key = if (PASSWORD_BASED_KEY) { //example for password based keys
                val salt = AesCbcWithIntegrity.saltString(AesCbcWithIntegrity.generateSalt())
                //If you generated the key from a password, you can store the salt and not the key.
                log("Salt: $salt", 0)
                AesCbcWithIntegrity.generateKeyFromPassword(EXAMPLE_PASSWORD, salt)
            } else {
                AesCbcWithIntegrity.generateKey()
                //Note: If you are generating a random key, you'll probably be storing it somewhere
            }

            // The encryption / storage & display:
            val keyStr = AesCbcWithIntegrity.keyString(key)
            key = null //Pretend to throw that away so we can demonstrate converting it from str
            val textToEncrypt =
                "Testing shows the presence, not the absence of bugs.\n\n  Edsger W. Dijkstra"
            log("Before encryption: $textToEncrypt", 0)

            // Read from storage & decrypt
            key =
                AesCbcWithIntegrity.keys(keyStr) // alternately, regenerate the key from password/salt.
            val civ = AesCbcWithIntegrity.encrypt(textToEncrypt, key)
            log("Encrypted: $civ", 0)
            val decryptedText = AesCbcWithIntegrity.decryptString(civ, key)
            log("Decrypted: $decryptedText", 0)
            //Note: "String.equals" is not a constant-time check, which can sometimes be problematic.
            log("Do they equal: " + (textToEncrypt == decryptedText), 0)
            etText.setText(decryptedText)
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
        private const val EXAMPLE_PASSWORD = "always use passphrases for passwords wherever possible!"
    }
}