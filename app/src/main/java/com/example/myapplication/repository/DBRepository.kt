package com.example.myapplication.repository

import com.example.myapplication.App
import com.example.myapplication.db.RestaurantListDatabase
import com.example.myapplication.db.entity.RestaurantEntity
import com.example.myapplication.db.entity.PhotoEntity

class DBRepository {
    val context = App.context()
    private val dbOfFavoriteRestaurant = RestaurantListDatabase.getDatabase(context)

    // Restaurant
    fun getRestaurantAllData() = dbOfFavoriteRestaurant.favoriteRestaurantDAO().querySelectAllDefault()

    fun getRestaurantSelectedData() = dbOfFavoriteRestaurant.favoriteRestaurantDAO().querySelectedData()

    fun getLatestRestaurantId() = dbOfFavoriteRestaurant.favoriteRestaurantDAO().getLatestRestaurantId()

    fun getPhotoReference(restaurantId: Int) = dbOfFavoriteRestaurant.favoriteRestaurantDAO().getPhotoReference(restaurantId)

    suspend fun insertRestaurantData(restaurantEntity: RestaurantEntity) =
        dbOfFavoriteRestaurant.favoriteRestaurantDAO().insertRestaurant(restaurantEntity)

    suspend fun insertPhotoData(photoEntity: PhotoEntity) =
        dbOfFavoriteRestaurant.favoriteRestaurantDAO().insertPhoto(photoEntity)

    suspend fun deleteRestaurantData(restaurantEntity: RestaurantEntity) =
        dbOfFavoriteRestaurant.favoriteRestaurantDAO().deleteRestaurant(restaurantEntity)

    suspend fun deletePhotoData(photoEntity: PhotoEntity) =
        dbOfFavoriteRestaurant.favoriteRestaurantDAO().deletePhoto(photoEntity)

}