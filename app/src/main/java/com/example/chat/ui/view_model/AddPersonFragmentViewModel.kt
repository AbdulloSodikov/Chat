package com.example.chat.ui.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.chat.model.Message
import com.example.chat.model.Person
import com.example.chat.utillite.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddPersonFragmentViewModel(application: Application) : AndroidViewModel(application) {

   fun insertPerson(person: Person) {
      viewModelScope.launch (Dispatchers.IO){
         REPOSITORY.insertPerson(person)
      }
   }
}