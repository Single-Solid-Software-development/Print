package uz.ssd.canvas

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Prefs constructor(
    private val context: Context
) {

    private fun getSharedPreferences(prefsName: String) =
        context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)

    private val KOD_MAP_PASSPORT = "kod_map_passport"
    private val KEY_MAP_PASSPORT = "key_map_passport"
    private val mapPassportPref by lazy { getSharedPreferences(KOD_MAP_PASSPORT) }

    var mapToken: HashMap<String, AesCbcWithIntegrity.CipherTextIvMac>
        get() {
            val json = mapPassportPref.getString(KEY_MAP_PASSPORT, "[]")!!
            return Gson()
                .fromJson(json, object : TypeToken<HashMap<String, AesCbcWithIntegrity.CipherTextIvMac>>() {}.type)
                ?: HashMap()
        }
        set(value) {
            val json = Gson().toJson(value)
            mapPassportPref.edit().putString(KEY_MAP_PASSPORT, json).apply()
        }
}