package com.noma.livestockcare.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    fun createRetrofit(): WorkersService {
        val retrofit = Retrofit.Builder().baseUrl("https://ivansfarm.000webhostapp.com")
            .addConverterFactory(GsonConverterFactory.create()).build()

        var service = retrofit.create(WorkersService::class.java)
        return service
    }
}