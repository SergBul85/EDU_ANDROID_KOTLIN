package com.example.sharedpref

import android.content.Context
import android.content.SharedPreferences

class SharedPrefManager(context: Context) {

    private val sp: SharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    fun saveString(key: String, value: String) {
        sp.edit().putString(key, value).apply()
    }

    fun getString(key: String): String {
        return sp.getString(key, "") ?: ""
    }

    fun saveInt(key: String, value: Int) {
        sp.edit().putInt(key, value).apply()
    }

    fun getInt(key: String): Int {
        return sp.getInt(key, 0)
    }


}