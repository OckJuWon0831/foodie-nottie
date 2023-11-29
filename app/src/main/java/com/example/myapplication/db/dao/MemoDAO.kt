package com.example.myapplication.db.dao

import androidx.room.*
import com.example.myapplication.db.entity.MemoEntity

@Dao
interface MemoDAO {
    @Query("SELECT * FROM memo_table")
    fun querySelectAll(): List<MemoEntity>

    // get based on the created time (last time order)
    @Query("SELECT * FROM memo_table ORDER BY id DESC")
    fun querySelectAllByLast(): List<MemoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(memoEntity: MemoEntity)

    @Delete()
    fun delete(memoEntity: MemoEntity)

    @Update()
    fun update(memoEntity: MemoEntity)
}