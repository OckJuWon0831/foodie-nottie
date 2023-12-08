package com.example.myapplication.db.dao

import androidx.room.*
import com.example.myapplication.db.entity.RestaurantEntity
import com.example.myapplication.db.entity.PhotoEntity
import com.example.myapplication.db.entity.RestaurantWithPhoto
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDAO {
    @Transaction
    @Query("SELECT * FROM restaurant_table")
    fun querySelectAllDefault(): Flow<List<RestaurantWithPhoto>>

    @Transaction
    @Query("SELECT * FROM restaurant_table WHERE selected = :selected")
    fun querySelectedData(selected: Boolean = true): Flow<List<RestaurantWithPhoto>>

    @Query("SELECT restaurantId FROM restaurant_table ORDER BY restaurantId DESC LIMIT 1")
    fun getLatestRestaurantId(): Int

    @Query("SELECT photoReference FROM photo_table WHERE restaurantReferId=:id")
    fun getPhotoReference(id : Int): String

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRestaurant(restaurantEntity: RestaurantEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPhoto(photoEntity: PhotoEntity)

    @Delete
    suspend fun deleteRestaurant(restaurantEntity: RestaurantEntity)

    @Delete
    suspend fun deletePhoto(photoEntity: PhotoEntity)
}