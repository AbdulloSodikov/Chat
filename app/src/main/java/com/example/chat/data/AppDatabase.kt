package com.example.chat.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chat.data.room.AppDao
import com.example.chat.model.Message
import com.example.chat.model.Person


@Database(
    entities = [
        Person::class,
        Message::class
    ],
    version = 1
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun getAppDao(): AppDao

    companion object {
        @Volatile
        private var instanceDatabase: AppDatabase? = null

        @Synchronized
        fun getInstanceDatabase(context: Context): AppDatabase {
            return if (instanceDatabase == null) {
                instanceDatabase = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                instanceDatabase as AppDatabase
            } else
                instanceDatabase as AppDatabase
        }

    }
}