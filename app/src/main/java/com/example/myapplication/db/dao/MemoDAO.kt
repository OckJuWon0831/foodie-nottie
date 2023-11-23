//package com.example.myapplication.db.dao
//
//import androidx.room.Dao
//import androidx.room.Delete
//import androidx.room.Query
//import androidx.room.Update
//import com.example.myapplication.db.entity.MemoEntity
//
//@Dao
//interface MemoDAO {
//    @Query("SELECT * FROM memo_table")
//    fun querySelectAllDefault(): List<MemoEntity>
//
//    @Query("SELECT * FROM memo_table ORDER BY id DESC")
//    fun querySelectAllByLast(): List<MemoEntity>
//
//    @Query("insert into memo_table(title,content) values(:title,:content)")
//    fun insert(title: String, content: String)
//
//    @Delete()
//    fun delete(memoEntity: MemoEntity)
//
//    @Update()
//    fun update(memoEntity: MemoEntity)
//}