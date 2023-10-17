package com.noma.livestockcare.retrofit

import com.noma.livestockcare.model.User
//import com.noma.livestockcare.model.WorkersModel
import com.noma.livestockcare.model.WorkersResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
//import retrofit2.Response
//import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface WorkersService {

    @GET("/api/get_users.php")
    suspend fun getWorkers(): WorkersResponse

    @FormUrlEncoded
    @POST("/api/insert_user.php")
    suspend fun addWorker(
        @Field("f_name")f_name:String,
        @Field("l_name")l_name:String,
        @Field("title")title:String,
        @Field("phone")phone:String,
        @Field("password")password:String,
        @Field("age")age:String,
        @Field("gender")gender:String?,
        @Field("image")image:String,
        ):WorkersResponse
}