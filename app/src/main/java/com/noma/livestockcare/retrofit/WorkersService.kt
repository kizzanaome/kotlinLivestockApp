package com.noma.livestockcare.retrofit

import com.noma.livestockcare.model.User
//import com.noma.livestockcare.model.WorkersModel
import com.noma.livestockcare.model.WorkersResponse
//import retrofit2.Response
//import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface WorkersService {

    @GET("/api/get_users.php")
    suspend fun getWorkers(): WorkersResponse

    @POST("/api/insert_user.php")
    suspend fun addWorker(worker: User)

}