//package com.example.myapplication.db
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.myapplication.db.dao.FavoriteRestaurantDAO
//import com.example.myapplication.db.entity.FavoriteRestaurantEntity
//
//@Database(entities = [FavoriteRestaurantEntity::class], version = 1)
//abstract class RestaurantListDatabase : RoomDatabase() {
//    abstract fun favoriteRestaurantDAO() : FavoriteRestaurantDAO
//
//    companion object {
//        @Volatile
//        private var INSTANCE : RestaurantListDatabase? = null
//
//        fun getDatabase(
//            context : Context
//        ) : RestaurantListDatabase {
//
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    RestaurantListDatabase::class.java,
//                    "restaurant_database"
//                )
//                    .fallbackToDestructiveMigration()
//                    .build()
//                INSTANCE = instance
//                instance
//            }
//
//        }
//
//    }
//}