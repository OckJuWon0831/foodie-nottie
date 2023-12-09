package com.example.myapplication.repository

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.myapplication.BuildConfig
import com.example.myapplication.dto.CurrentCoordinates
import com.example.myapplication.network.RetrofitInstance
import com.example.myapplication.network.model.NearPlaceResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NetworkRepository {
    private val api = RetrofitInstance.getApi()

    companion object {
        private var coordinates: CurrentCoordinates? = null

        fun setCoordinates(coords: CurrentCoordinates) {
            coordinates = coords
        }
    }

    suspend fun getNearRestaurantsList(): NearPlaceResponse {
        val currentCoordinates = coordinates
            ?: throw IllegalStateException("Coordinates have not been initialized.")

        val keyword = "restaurant"
        val location = "${currentCoordinates.latitude},${currentCoordinates.longitude}"
        val radius = 2000
        val type = "restaurant"
        val apiKey = BuildConfig.GOOGLE_MAP_API_KEY

        return api.getNearRestaurantsList(keyword, location, radius, type, apiKey)
    }
}