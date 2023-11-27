package com.example.myapplication.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class PhotoEntity(
    @PrimaryKey(autoGenerate = true)
    val photoId: Int,
    val photoReference: String,
    val width: Int,
    val height: Int
)