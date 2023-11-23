package com.example.myapplication.dataModels

import com.google.gson.annotations.SerializedName

data class CurrentCoordinates(
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String
)