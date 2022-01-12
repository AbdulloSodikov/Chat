package com.example.chat.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chat.model.Message
import com.example.chat.model.Person

@Dao
interface AppDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPerson(person: Person)

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMessage(message: Message)

    @Query("SELECT * FROM person ")
    fun getAllPerson(): LiveData<List<Person>>

    @Query("SELECT * FROM message WHERE personId = :personId")
    fun getMessageInIdPerson(personId : Int): LiveData<List<Message>>
}