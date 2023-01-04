package org.techtown.politicsproject.mainfun

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(context: Context) {

    private val prefsFilename = "prefs"
    private val initGuName = "guName"
    private val prefs: SharedPreferences = context.getSharedPreferences(prefsFilename, 0)

    var myEditText: String?
        get() = prefs.getString(initGuName, "guName")
        set(value) = prefs.edit().putString(initGuName, value).apply()
}