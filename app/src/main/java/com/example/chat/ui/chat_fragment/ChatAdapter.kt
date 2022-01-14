package com.example.chat.ui.chat_fragment


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chat.R
import com.example.chat.model.Message

class ChatAdapter : RecyclerView.Adapter<ChatAdapter.ChatHolder> (){
    private var messageList = emptyList<Message>()


    inner class ChatHolder (view: View) : RecyclerView.ViewHolder(view) {
        val message : TextView = view.findViewById(R.id.send_my_message)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)
        return ChatHolder(view)
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {

        holder.message.text = messageList[position].message
    }

    override fun getItemCount(): Int = messageList.size

    fun setMessageList (list : List<Message>){
        messageList = list
        notifyDataSetChanged()
    }

}