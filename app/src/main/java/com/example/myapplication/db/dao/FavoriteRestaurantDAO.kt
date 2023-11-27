package com.example.myapplication.db.dao

import androidx.room.*
import com.example.myapplication.db.entity.FavoriteRestaurantEntity
import com.example.myapplication.db.entity.PhotoEntity
import com.example.myapplication.db.entity.RestaurantWithPhoto
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteRestaurantDAO {
    @Transaction
    @Query("SELECT * FROM favorite_restaurant_table")
    fun querySelectAllDefault(): Flow<List<RestaurantWithPhoto>>

    @Transaction
    @Query("SELECT * FROM favorite_restaurant_table WHERE selected = :selected")
    fun querySelectedData(selected: Boolean = true): Flow<List<RestaurantWithPhoto>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRestaurant(favoriteRestaurantEntity: FavoriteRestaurantEntity)

    @Query("SELECT restaurantId FROM favorite_restaurant_table ORDER BY restaurantId DESC LIMIT 1")
    fun getLatestRestaurantId(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPhoto(photoEntity: PhotoEntity)

    @Delete
    suspend fun deleteRestaurant(favoriteRestaurantEntity: FavoriteRestaurantEntity)

    @Delete
    suspend fun deletePhoto(photoEntity: PhotoEntity)
}