package com.example.myapplication.db.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_restaurant_table")
data class FavoriteRestaurantEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val businessStatus: String,
    val name: String,
    @Embedded
    val photos: PhotoEntity,
    val placeId: String,
    val rating: Double,
    val userRatingsTotal: Int,
    val vicinity: String,
    val selected: Boolean
)