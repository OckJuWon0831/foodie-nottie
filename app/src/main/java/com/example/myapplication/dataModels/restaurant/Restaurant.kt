package com.example.myapplication.dataModels.restaurant

import com.example.myapplication.dataModels.restaurant.OpeningHours
import com.example.myapplication.dataModels.restaurant.Photo
import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("business_status")
    val businessStatus: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("opening_hours")
    val openingHours: OpeningHours,
    @SerializedName("photos")
    val photos: List<Photo>,
    @SerializedName("place_id")
    val placeId: String,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("types")
    val types: List<String>,
    @SerializedName("user_ratings_total")
    val userRatingsTotal: Int,
    @SerializedName("vicinity")
    val vicinity: String
)



