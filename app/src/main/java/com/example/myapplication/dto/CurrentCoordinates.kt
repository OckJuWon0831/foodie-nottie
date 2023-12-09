package com.example.myapplication.dto

import com.google.gson.annotations.SerializedName

data class CurrentCoordinates(
    @SerializedName("latitude")
    var latitude: String,
    @SerializedName("longitude")
    var longitude: String
)