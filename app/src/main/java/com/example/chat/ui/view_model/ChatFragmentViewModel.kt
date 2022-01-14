package com.example.chat.ui.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.chat.model.Message
import com.example.chat.utillite.REPOSITORY

class ChatFragmentViewModel(application: Application) : AndroidViewModel(application) {

   fun getMessage (personId : Int) : LiveData<List<Message>> {
      return REPOSITORY.getMessageInPersonId(personId)
   }

}