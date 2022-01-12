package com.example.chat.data.room

import androidx.lifecycle.LiveData
import com.example.chat.model.Message
import com.example.chat.model.Person

class AppRoomRepository (private val dao : AppDao) {

     fun getAllPerson():LiveData<List<Person>> {
        return dao.getAllPerson()
    }
     fun getMessageInPersonId(_personId: Int):LiveData<List<Message>> {
        return dao.getMessageInIdPerson(_personId)
    }

    suspend fun insertPerson(_person: Person) {
        dao.insertPerson(_person)
    }

    suspend fun insertMessage(_message: Message) {
        dao.insertMessage(_message)
    }

}