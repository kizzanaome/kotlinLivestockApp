package com.noma.livestockcare.retrofit

import com.noma.livestockcare.model.ProductsResponse
import retrofit2.http.GET

interface ProductsService {

    @GET("/api/get_purchases.php")
    suspend fun getProducts(): ProductsResponse



}