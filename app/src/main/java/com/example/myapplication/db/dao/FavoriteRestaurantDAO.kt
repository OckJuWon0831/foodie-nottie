//package com.example.myapplication.db.dao
//
//import androidx.room.*
//import com.example.myapplication.db.entity.FavoriteRestaurantEntity
//import kotlinx.coroutines.flow.Flow
//
//@Dao
//interface FavoriteRestaurantDAO {
//
//    @Query("SELECT * FROM favorite_restaurant_table")
//    fun querySelectAllDefault() : Flow<List<FavoriteRestaurantEntity>>
//
//    @Query("SELECT * FROM favorite_restaurant_table WHERE selected = :selected")
//    fun querySelectedData(selected : Boolean = true) : List<FavoriteRestaurantEntity>
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun insert(favoriteRestaurantEntity: FavoriteRestaurantEntity)
//
//    @Update
//    fun update(favoriteRestaurantEntity: FavoriteRestaurantEntity)
//
//    @Delete
//    fun delete(favoriteRestaurantEntity: FavoriteRestaurantEntity)
//}