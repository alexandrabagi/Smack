package com.example.smack.Controller

import android.app.Application
import com.example.smack.Utilities.SharedPrefs

/**
 * Here we can provide a global base context
 */

class App : Application() {

    companion object {
        // only one instance is allowed
        // accessible from anywhere in the application
        lateinit var prefs: SharedPrefs
    }

    override fun onCreate() {
        prefs = SharedPrefs(applicationContext)
        super.onCreate()
    }
}