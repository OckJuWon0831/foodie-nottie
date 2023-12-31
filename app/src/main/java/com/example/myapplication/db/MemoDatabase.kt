package com.example.myapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.db.dao.MemoDAO
import com.example.myapplication.db.entity.MemoEntity

@Database(entities = [MemoEntity::class], version = 1)
abstract class MemoDatabase : RoomDatabase() {
    abstract fun memoDao() : MemoDAO

    companion object {
        @Volatile
        private var INSTANCE : MemoDatabase? = null

        fun getDatabase(
            context : Context
        ) : MemoDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MemoDatabase::class.java,
                    "memo_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}