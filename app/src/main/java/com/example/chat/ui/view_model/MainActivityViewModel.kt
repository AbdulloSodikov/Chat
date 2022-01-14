package com.example.chat.ui.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.chat.R
import com.example.chat.data.AppDatabase
import com.example.chat.data.room.AppRoomRepository
import com.example.chat.model.Message
import com.example.chat.model.Person
import com.example.chat.utillite.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application

    private val personList = listOf(
        Person(1, "Parviz Ibodov", R.drawable.person_1),
        Person(2, "Abdullo Sodikov", R.drawable.person_2),
        Person(3, "Islom Nuriddinov", R.drawable.person_3),
        Person(4, "Mati Sattorova", R.drawable.person_4),
        Person(5, "Nilu Nilu", R.drawable.person_5),
        Person(6, "Mavzuna Abbosova", R.drawable.person_6)
    )


    fun init() {
        val dao = AppDatabase.getInstanceDatabase(mContext).getAppDao()
        REPOSITORY = AppRoomRepository(dao)
        viewModelScope.launch(Dispatchers.IO) {
            personList.forEach { REPOSITORY.insertPerson(it) }
            // Log.e("MY_TEG", dao.getAllPerson().toString())
        }
    }
}