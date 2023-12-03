package com.example.myapplication.db.dao

import androidx.room.*
import com.example.myapplication.db.entity.MemoEntity
import com.example.myapplication.dto.Memo

@Dao
interface MemoDAO {
    @Query("SELECT * FROM memo_table")
    fun querySelectAll(): List<MemoEntity>

    // get based on the created time (last time order)
    @Query("SELECT * FROM memo_table ORDER BY id DESC")
    fun querySelectAllByLast(): List<MemoEntity>

    @Query("SELECT id FROM memo_table WHERE title=:title")
    fun querySelectId(title : String): Int

//    @Query("SELECT * FROM memo_table WHERE title=:title")
//    fun querySelectFromTitle(title : String): List<MemoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(memoEntity: MemoEntity)

    @Delete()
    fun delete(memoEntity: MemoEntity)

    @Query("UPDATE memo_table SET title=:title, content=:content, createdDate=:createdDate WHERE id=:id")
    fun update(title : String, content : String, createdDate : String?, id : Int)


}