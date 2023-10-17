package com.noma.livestockcare.model

import android.util.Log
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductsDao {
    //    @Insert(entity = WorkersModel::class)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(productsModel:ProductsModel)

    @Query("Select * from productsTable")
    fun getAllProducts(): List<ProductsModel>
}