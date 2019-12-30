package com.example.smack.Services

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.smack.Utilities.URL_REGISTER
import org.json.JSONObject

object AuthService {

// example from video
//    fun registerUser(context: Context, email: String, password: String, complete: (Boolean) -> Unit) {
//
//        val url = URL_REGISTER
//
//        // JSON body
//        val jsonBody = JSONObject()
//        jsonBody.put("email", email)
//        jsonBody.put("password", password)
//        val requestBody = jsonBody.toString()
//
//        //                             web request          method type       response
//        val registerRequest = object: StringRequest(Request.Method.POST, url, Response.Listener { _ ->
//            complete(true)
//        },
//            // error response
//            Response.ErrorListener { error ->
//            Log.d("ERROR", "Could not register user: $error")
//            complete(false)
//        }) {
//            // specifying the content type
//            override fun getBodyContentType(): String {
//                return "application/json; charset=utf-8"
//            }
//
//            override fun getBody(): ByteArray {
//                return requestBody.toByteArray()
//            }
//        }
//        // adding to queue
//        Volley.newRequestQueue(context).add(registerRequest)
//    }
}