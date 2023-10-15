package com.noma.livestockcare.model

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

class DBBuilder {

//    val db = RoomDatabase.Builder()

    fun createDB(context:Context): WorkersDatabase {
//        val db = Room.databaseBuilder(context, WorkersDatabase::class.java, "roomDB").build()
        val db = Room.databaseBuilder(context, WorkersDatabase::class.java, "roomDB").fallbackToDestructiveMigration().build()
        return db
    }

}