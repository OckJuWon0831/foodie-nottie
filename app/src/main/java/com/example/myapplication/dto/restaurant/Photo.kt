package com.example.myapplication.dto.restaurant

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("height")
    val height: Int,
    @SerializedName("photo_reference")
    val photoReference: String,
    @SerializedName("width")
    val width: Int
)