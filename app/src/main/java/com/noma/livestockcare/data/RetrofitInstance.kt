package com.noma.livestockcare.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    fun createRetrofit(): LivestockService {
        val retrofit = Retrofit.Builder().baseUrl("https://ivansfarm.000webhostapp.com")
            .addConverterFactory(GsonConverterFactory.create()).build()

        var service = retrofit.create(LivestockService::class.java)
        return service
    }
}