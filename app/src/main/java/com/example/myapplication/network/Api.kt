package com.example.myapplication.network

import com.example.myapplication.network.model.NearPlaceResponse
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Streaming


interface Api {
    @GET("place/nearbysearch/json")
    suspend fun getNearRestaurantsList(
        @Query("keyword") keyword: String,
        @Query("location") location: String,
        @Query("radius") radius: Int,
        @Query("type") type: String,
        @Query("key") apiKey: String
    ): NearPlaceResponse
}