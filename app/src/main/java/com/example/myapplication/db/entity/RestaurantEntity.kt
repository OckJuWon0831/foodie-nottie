package com.example.myapplication.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant_table")
data class RestaurantEntity(
    @PrimaryKey(autoGenerate = true)
    val restaurantId : Int,
    val businessStatus: String,
    val name: String,
    val placeId: String,
    val rating: Double,
    val userRatingsTotal: Int,
    val vicinity: String,
    // define whether it is selected as a favorite one
    val selected: Boolean,
    )