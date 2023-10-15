package com.noma.livestockcare.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class WorkersResponse(
    var responseCode:Int?,
    var message:String?,
    var response:ArrayList<User>,
)

@Entity(tableName="workersTable")
data class User(
//    var id:String?,
    @PrimaryKey(autoGenerate = true) val id : Int?,
    var f_name:String?,
    var l_name:String?,
    var title:String?,
    var phone:String?,
    var image:String?,
    var password:String?,
    var age: String?,
    var gender:String?,
)