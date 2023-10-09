package com.noma.livestockcare.data

data class LivestockModal(
    var responseCode:Int,
    var message:String,
    var response:List<Response1>,
)

data class Response1(
    //    var id:String,
    var f_name:String
//    var l_name:String,
//    var title:String,
//    var phone:String,
//    var image:String,
//    var password:String,
//    var age: Int
)
