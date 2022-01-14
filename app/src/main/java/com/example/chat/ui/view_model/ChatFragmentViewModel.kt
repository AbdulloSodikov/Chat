package com.example.chat.ui.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.chat.model.Message
import com.example.chat.utillite.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChatFragmentViewModel(application: Application) : AndroidViewModel(application) {

   fun getMessage (personId : Int) : LiveData<List<Message>> {
      return REPOSITORY.getMessageInPersonId(personId)
   }

   fun insertMessage(message:Message) {
      viewModelScope.launch (Dispatchers.IO){
         REPOSITORY.insertMessage(message)
      }
   }
}