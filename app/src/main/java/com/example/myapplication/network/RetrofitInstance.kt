package com.example.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL_PLACES = "https://maps.googleapis.com/maps/api/place/"
    private val client = Retrofit
        .Builder()
        .baseUrl(BASE_URL_PLACES)
        .addConverterFactory(GsonConverterFactory. create())
        .build()

    fun getInstance(): Retrofit {
        return client
    }
}