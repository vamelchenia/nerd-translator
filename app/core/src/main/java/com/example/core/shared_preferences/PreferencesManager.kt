package com.example.core.shared_preferences

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {

    private val preferencesName = "NerdTranslatorSharedPreferences"
    private var sharedPref: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        sharedPref = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun put(key: String?, value: String) {
        editor.putString(key, value)
            .apply()
    }

    fun put(key: String, value: Boolean) {
        editor.putBoolean(key, value)
            .apply()
    }

    fun getString(key: String): String? {
        return sharedPref.getString(key, null)
    }

    fun getBoolean(key: String): Boolean {
        return sharedPref.getBoolean(key, false)
    }

    fun clear() {
        editor.clear()
            .apply()
    }
}