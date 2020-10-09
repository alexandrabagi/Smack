package com.example.smack.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smack.Model.Message
import com.example.smack.R
import com.example.smack.Services.UserDataService
import org.w3c.dom.Text
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MessageAdapter(val context: Context, val messages: ArrayList<Message>) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.message_list_item, parent, false)
        return MessageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return messages.count()
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bindMessage(context, messages[position])
    }

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImage = itemView.findViewById<ImageView>(R.id.messageUserImage)
        val timeStamp = itemView.findViewById<TextView>(R.id.timeStampLabel)
        val userName = itemView.findViewById<TextView>(R.id.messageUserNameLabel)
        val messageBody = itemView.findViewById<TextView>(R.id.messageBodyLabel)

        fun bindMessage(context: Context, message: Message) {
            val resourceId = context.resources.getIdentifier(message.userAvatar, "drawable", context.packageName)
            userImage?.setImageResource(resourceId)
            userImage?.setBackgroundColor(UserDataService.returnAvatarColor(message.userAvatarColor))
            userName?.text = message.userName
            timeStamp?.text = returnDateString(message.timeStamp)
            messageBody?.text = message.message
        }

        fun returnDateString(isoString: String) : String {

            // 2020-10-09T09:36:12.118Z - iso 8601
            // Friday 9:36 PM

            val isoFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault()) // pattern that match the original
            isoFormatter.timeZone = TimeZone.getTimeZone("UTC")
            var convertedDate = Date()
            try {
                convertedDate = isoFormatter.parse(isoString)
            } catch(e: ParseException) {
                Log.d("PARSE", "Cannot parse date")
            }

            val outDateString = SimpleDateFormat("E, h:mm a", Locale.getDefault())

            return outDateString.format(convertedDate)
        }
    }
}