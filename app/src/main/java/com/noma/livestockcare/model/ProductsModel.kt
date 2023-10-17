package com.noma.livestockcare.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="productsTable")
data class ProductsModel(
//    var id:String?,
    @PrimaryKey(autoGenerate = true) val id : Int?,
    var product:String?,
    var price:String?,
    var quantity:String?,
    var description:String?,
    var purchased_from:String?,
    var purchased_on:String?,
)
