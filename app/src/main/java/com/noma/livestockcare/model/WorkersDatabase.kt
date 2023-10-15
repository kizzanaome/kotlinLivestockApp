package com.noma.livestockcare.model

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [WorkersModel::class], version = 1)
abstract class WorkersDatabase:RoomDatabase() {
    abstract  fun workersDao():WorkersDao
}