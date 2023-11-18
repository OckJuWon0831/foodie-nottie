package com.example.myapplication.network

import com.example.myapplication.network.model.NearPlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api  {

    @GET("place/nearbysearch/json?keyword=restaurant&location=2.943836%2C101.873622&radius=2000&type=restaurant&key=AIzaSyDsJtQSz4ogXf8N_y5DfyUw3WAU-U9-hX4")
    suspend fun getNearRestaurantsList(
    ) : NearPlaceResponse
}
