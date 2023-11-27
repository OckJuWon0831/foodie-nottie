package com.example.myapplication.repository

import com.example.myapplication.App
import com.example.myapplication.db.MemoDatabase
import com.example.myapplication.db.RestaurantListDatabase
import com.example.myapplication.db.entity.FavoriteRestaurantEntity
import com.example.myapplication.db.entity.MemoEntity

class DBRepository {
    val context = App.context()
    private val dbOfFavoriteRestaurant = RestaurantListDatabase.getDatabase(context)
    private val dbOfMemo = MemoDatabase.getDatabase(context)

    // Restaurant
    fun getRestaurantAllData() = dbOfFavoriteRestaurant.favoriteRestaurantDAO().querySelectAllDefault()

    fun getRestaurantSelectedData() = dbOfFavoriteRestaurant.favoriteRestaurantDAO().querySelectedData()

    fun insertRestaurantData(favoriteRestaurantEntity: FavoriteRestaurantEntity) =
        dbOfFavoriteRestaurant.favoriteRestaurantDAO().insert(favoriteRestaurantEntity)

    fun updateRestaurantData(favoriteRestaurantEntity: FavoriteRestaurantEntity) =
        dbOfFavoriteRestaurant.favoriteRestaurantDAO().update(favoriteRestaurantEntity)

    fun deleteRestaurantData(favoriteRestaurantEntity: FavoriteRestaurantEntity) =
        dbOfFavoriteRestaurant.favoriteRestaurantDAO().delete(favoriteRestaurantEntity)

    // Memo
    fun getMemoAllData() = dbOfMemo.memoDao().querySelectAllDefault()

    fun getSelectAllByLast() = dbOfMemo.memoDao().querySelectAllByLast()

    fun insertMemoData(memoEntity: MemoEntity) = dbOfMemo.memoDao().insert(memoEntity.title, memoEntity.content)

    fun updateMemoData(memoEntity: MemoEntity) = dbOfMemo.memoDao().update(memoEntity)

    fun deleteMemoData(memoEntity: MemoEntity) = dbOfMemo.memoDao().delete(memoEntity)
}