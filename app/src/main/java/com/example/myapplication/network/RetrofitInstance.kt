package com.example.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    private const val BASE_URL_PLACES = "https://maps.googleapis.com/maps/api/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_PLACES)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApi(): Api {
        return retrofit.create(Api::class.java)
    }
}