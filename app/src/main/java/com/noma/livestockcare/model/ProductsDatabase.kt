package com.noma.livestockcare.model

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [ProductsModel::class], version = 2)
abstract class ProductsDatabase:RoomDatabase() {
    abstract  fun productsDao():ProductsDao
}