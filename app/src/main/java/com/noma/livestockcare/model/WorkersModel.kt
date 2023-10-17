package com.noma.livestockcare.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="workersTable")
data class WorkersModel(
    @PrimaryKey(autoGenerate = true) val id : Int?,
    val firstName:String,
    val lastName:String,
    val phoneNumber:String,
    val password:String,
    val age:String?,
    val role:String,
    val gender:String?,
    val image:String?
)
