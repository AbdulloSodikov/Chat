package com.example.chat.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "message")
data class Message (
    @PrimaryKey (autoGenerate = false)
    @ColumnInfo (name = "PersonId")
    val personId : Int,

    @ColumnInfo (name = "messege")
    val message: String

        ) {
}