package com.noma.livestockcare.data

data class LivestockResponse(
    var responseCode:Int,
    var message:String,
    var response:ArrayList<User>,
)

data class User(
    var id:String,
    var f_name:String,
    var l_name:String,
    var title:String,
    var phone:String,
    var image:String,
    var password:String,
    var age: Int
)

//{
//    "responseCode": 200,
//    "message": "Successful",
//    "response": [
//        {
//            "id": "1",
//            "f_name": "Peter",
//            "l_name": "Ivan",
//            "title": "Owner",
//            "phone": "0704253811",
//            "image": null,
//            "password": "123456",
//            "age": null
//        },
//        {
//            "id": "2",
//            "f_name": "Derrick",
//            "l_name": "Mutebi",
//            "title": "Manager",
//            "phone": "0704253812",
//            "image": null,
//            "password": "mutebi",
//            "age": null
//        },
//        {
//            "id": "3",
//            "f_name": "James",
//            "l_name": "Lunda",
//            "title": "Worker",
//            "phone": "0701234567",
//            "image": null,
//            "password": "james",
//            "age": null
//        }
//    ]
//}