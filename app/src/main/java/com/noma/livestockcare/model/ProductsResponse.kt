package com.noma.livestockcare.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ProductsResponse(
    var errorCode:Int?,
    var message:String?,
    var response:ArrayList<Product>,
)

@Entity(tableName="productsTable")
data class Product(
//    var id:String?,
    @PrimaryKey(autoGenerate = true) val id : Int?,
    var product:String?,
    var price:String?,
    var quantity:String?,
    var description:String?,
    var purchased_from:String?,
    var purchased_on:String?,
)