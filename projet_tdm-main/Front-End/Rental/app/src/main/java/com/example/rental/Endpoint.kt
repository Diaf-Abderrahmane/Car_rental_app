package com.example.rental

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoint {

    @GET("getuser/{email}/{password}")
   suspend fun verifyUser(@Path("email")email:String,@Path("password")password:String):Response<User?> // cette méthode invoque le service

    @GET("getusers")
    fun getUsers():Response<List<User>>

     @GET("simple")
     suspend fun simple():Response<String>
//    @GET("getcars")
//    suspend fun getcars():Response<List<>>
}