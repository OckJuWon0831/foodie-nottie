package com.example.myapplication.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class RestaurantWithPhoto(
    @Embedded val restaurant: RestaurantEntity,
    @Relation (
        entity = PhotoEntity::class,
        parentColumn = "restaurantId",
        entityColumn = "restaurantReferId"
    )
    val photo: PhotoEntity
)
