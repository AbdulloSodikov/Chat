package com.example.chat.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "person")
data class Person(
    @PrimaryKey (autoGenerate = false)
    @ColumnInfo (name = "personId")
    val personId : Int,

    @ColumnInfo(name = "personName")
    val personName : String
)

