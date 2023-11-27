package com.example.myapplication.repository

import com.example.myapplication.network.Api
import com.example.myapplication.network.RetrofitInstance

class NetworkRepository {
    private val client = RetrofitInstance.getInstance().create(Api::class.java)

    suspend fun getNearRestaurantsList() = client.getNearRestaurantsList()
}