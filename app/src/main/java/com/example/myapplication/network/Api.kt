package com.example.myapplication.network

import com.android.volley.toolbox.ImageRequest
import com.example.myapplication.network.model.NearPlaceResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
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

    @POST("place/photo")
    suspend fun postImageOfRestaurant(
        @Query("maxheight") maxheight: Int,
        @Query("maxwidth") maxwidth: Int,
        @Query("photo_reference") reference: String,
        @Query("key") apiKey: String
    ) : Call<ResponseBody>
}