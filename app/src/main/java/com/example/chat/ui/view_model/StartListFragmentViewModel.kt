package com.example.chat.ui.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.chat.utillite.REPOSITORY

class StartListFragmentViewModel (application: Application) : AndroidViewModel(application) {

    val getAllPerson = REPOSITORY.getAllPerson()

}