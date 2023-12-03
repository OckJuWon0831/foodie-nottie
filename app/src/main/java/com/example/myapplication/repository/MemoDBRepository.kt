package com.example.myapplication.repository

import com.example.myapplication.App
import com.example.myapplication.db.MemoDatabase
import com.example.myapplication.db.entity.MemoEntity
import com.example.myapplication.dto.Memo

class MemoDBRepository {
    val context = App.context()
    private val dbOfMemo = MemoDatabase.getDatabase(context)

    // Memo
    fun getMemoAllData() = dbOfMemo.memoDao().querySelectAll()

    fun getSelectAllByLast() = dbOfMemo.memoDao().querySelectAllByLast()

    fun getIdByTitle(title : String) = dbOfMemo.memoDao().querySelectId(title)

    fun insertMemoData(memoEntity: MemoEntity) = dbOfMemo.memoDao().insert(memoEntity)

    fun updateMemoData(memoEntity: MemoEntity) = dbOfMemo.memoDao().update(memoEntity.title, memoEntity.content, memoEntity.createdDate, memoEntity.id)

    fun deleteMemoData(memoEntity: MemoEntity) = dbOfMemo.memoDao().delete(memoEntity)
}