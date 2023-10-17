package com.noma.livestockcare.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductsRetrofitInstance {

    fun createRetrofit(): ProductsService {
        val retrofit = Retrofit.Builder().baseUrl("https://ivansfarm.000webhostapp.com")
            .addConverterFactory(GsonConverterFactory.create()).build()

        var service = retrofit.create(ProductsService::class.java)
        return service
    }
}