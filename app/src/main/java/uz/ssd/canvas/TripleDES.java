package uz.ssd.canvas;

import android.util.Base64;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import kotlin.text.Charsets;

/**
 * Created by mr-shoxruxbek on 16/11/2020.
 */
public class TripleDES {

    private static final String secretKey = "56883258c6be20c60aeeb161d48p23ff";

    public static String encrypt(String message) {

        String result = "";
        try {
            byte[] keyBytes = Arrays.copyOf(secretKey.getBytes(), 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = message.getBytes(Charsets.UTF_8);
            byte[] buf = cipher.doFinal(plainTextBytes);
            result = Base64.encodeToString(buf, Base64.NO_WRAP);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String decrypt(String encryptedText) {

        String result = "";
        try {
            byte[] message = Base64.decode(encryptedText.getBytes(Charsets.UTF_8), Base64.DEFAULT);

            byte[] keyBytes = Arrays.copyOf(secretKey.getBytes(), 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede/ECB/PKCS5Padding", "BC");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);
            result = new String(plainText, Charsets.UTF_8);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return result;
    }

}
