package com.example.myapplication.dto

import com.google.gson.annotations.SerializedName

data class CurrentCoordinates(
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String
)