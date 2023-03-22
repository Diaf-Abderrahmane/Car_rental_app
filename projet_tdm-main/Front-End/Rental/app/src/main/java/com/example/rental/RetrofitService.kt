package com.example.rental

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

        val endpoint = Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(Endpoint::class.java)



}