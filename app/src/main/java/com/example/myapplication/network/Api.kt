package com.example.myapplication.network

import com.example.myapplication.network.model.NearPlaceResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

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