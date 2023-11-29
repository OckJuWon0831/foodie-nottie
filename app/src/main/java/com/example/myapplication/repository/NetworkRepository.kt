package com.example.myapplication.repository

import com.example.myapplication.BuildConfig
import com.example.myapplication.network.RetrofitInstance
import com.example.myapplication.network.model.NearPlaceResponse

class NetworkRepository {
    private val api = RetrofitInstance.getApi()

    suspend fun getNearRestaurantsList(): NearPlaceResponse {
        val keyword = "restaurant"
        val location = BuildConfig.NOTTINGHAM_LOCATION
        val radius = 2000
        val type = "restaurant"
        val apiKey = BuildConfig.GOOGLE_MAP_API_KEY

        return api.getNearRestaurantsList(keyword, location, radius, type, apiKey)
    }
}