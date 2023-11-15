package com.example.myapplication.dataModel

import com.google.gson.annotations.SerializedName

data class Restuarant(
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



