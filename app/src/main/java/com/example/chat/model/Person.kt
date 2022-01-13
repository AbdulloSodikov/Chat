package com.example.chat.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity (tableName = "person")
data class Person(
    @PrimaryKey (autoGenerate = false)
    @ColumnInfo
    val personId : Int,

    @ColumnInfo
    val personName : String,

    @ColumnInfo
    val urlPersonAvatar : Int
) : Serializable

