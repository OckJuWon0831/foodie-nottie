//package com.example.myapplication.db.entity
//
//import androidx.room.Embedded
//import androidx.room.Relation
//
//data class RestaurantWithPhoto(
//    @Embedded val restaurant: FavoriteRestaurantEntity,
//    @Relation (
//        parentColumn = "restaurantId",
//        entityColumn = "photoId"
//    )
//    val photo: List<PhotoEntity>
//)
