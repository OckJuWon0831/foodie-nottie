package com.example.myapplication.repository

import com.example.myapplication.App
import com.example.myapplication.db.RestaurantListDatabase
import com.example.myapplication.db.entity.FavoriteRestaurantEntity
import com.example.myapplication.db.entity.PhotoEntity

class DBRepository {
    val context = App.context()
    private val dbOfFavoriteRestaurant = RestaurantListDatabase.getDatabase(context)

    // Restaurant
    fun getRestaurantAllData() = dbOfFavoriteRestaurant.favoriteRestaurantDAO().querySelectAllDefault()

    fun getRestaurantSelectedData() = dbOfFavoriteRestaurant.favoriteRestaurantDAO().querySelectedData()

    fun getLatestRestaurantId() = dbOfFavoriteRestaurant.favoriteRestaurantDAO().getLatestRestaurantId()

    suspend fun insertRestaurantData(favoriteRestaurantEntity: FavoriteRestaurantEntity) =
        dbOfFavoriteRestaurant.favoriteRestaurantDAO().insertRestaurant(favoriteRestaurantEntity)

    suspend fun insertPhotoData(photoEntity: PhotoEntity) =
        dbOfFavoriteRestaurant.favoriteRestaurantDAO().insertPhoto(photoEntity)

    suspend fun deleteRestaurantData(favoriteRestaurantEntity: FavoriteRestaurantEntity) =
        dbOfFavoriteRestaurant.favoriteRestaurantDAO().deleteRestaurant(favoriteRestaurantEntity)

    suspend fun deletePhotoData(photoEntity: PhotoEntity) =
        dbOfFavoriteRestaurant.favoriteRestaurantDAO().deletePhoto(photoEntity)

}