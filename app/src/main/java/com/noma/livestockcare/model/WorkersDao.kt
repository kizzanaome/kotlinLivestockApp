package com.noma.livestockcare.model

import android.util.Log
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WorkersDao {
//    @Insert(entity = WorkersModel::class)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWorker(workersModel:WorkersModel)

    @Query("Select * from workersTable")
    fun getAllWorkers(): List<WorkersModel>
}