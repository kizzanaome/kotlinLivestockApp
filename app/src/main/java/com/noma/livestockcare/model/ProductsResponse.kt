package com.noma.livestockcare.model

data class ProductsResponse(
    var errorCode:Int?,
    var message:String?,
    var response:ArrayList<User>,
)

data class Product(
    var id:String?,
    var product:String?,
    var price:String?,
    var quantity:String?,
    var description:String?,
    var purchased_from:String?,
    var purchased_on:String?,
)