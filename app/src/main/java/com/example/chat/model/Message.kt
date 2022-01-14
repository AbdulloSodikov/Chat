package com.example.chat.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "message")
data class Message (
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo
    val id : Int = 0,

    @ColumnInfo (name = "PersonId")
    val personId : Int,

    @ColumnInfo (name = "message")
    val message: String

        )
{
}