package com.example.smack.Services

import android.graphics.Color
import com.example.smack.Controller.App
import java.util.*

object UserDataService {

    var id = ""
    var avatarColor = ""
    var avatarName = ""
    var email = ""
    var name = ""

    fun returnAvatarColor(components: String) : Int {
        // [0.7647058823529411, 0.596078431372549, 0.8666666666666667, 1]
        // R                    G                  B                alfa

        val strippedColor = components
            .replace("[", "")
            .replace("]", "")
            .replace(",", "")

        var r = 0
        var g = 0
        var b = 0

        val sc = Scanner(strippedColor)
        if (sc.hasNext()) {
            r = (sc.nextDouble() * 255).toInt()
            g = (sc.nextDouble() * 255).toInt()
            b = (sc.nextDouble() * 255).toInt()
        }

        return Color.rgb(r, g, b)
    }

    fun logout() {
        id = ""
        avatarColor = ""
        avatarName = ""
        email = ""
        name = ""
        App.prefs.userEmail = ""
        App.prefs.authToken = ""
        App.prefs.isLoggedIn = false
        MessageService.clearChannels()
        MessageService.clearMessages()
    }
}