package com.noma.livestockcare.data

//import retrofit2.Response
import retrofit2.http.GET

interface LivestockService {
//    https://ivansfarm.000webhostapp.com/api/get_users.php

    @GET("/api/get_users.php")
    suspend fun getWorkers():LivestockResponse
//    suspend fun getWorkers(): ArrayList<Response>
//    suspend fun getWorkers(): Response<LivestockResponse>

}