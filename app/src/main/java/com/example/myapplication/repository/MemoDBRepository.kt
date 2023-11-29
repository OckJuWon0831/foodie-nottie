package com.example.myapplication.repository

import com.example.myapplication.App
import com.example.myapplication.db.MemoDatabase
import com.example.myapplication.db.entity.MemoEntity

class MemoDBRepository {
    val context = App.context()
    private val dbOfMemo = MemoDatabase.getDatabase(context)

    // Memo
    fun getMemoAllData() = dbOfMemo.memoDao().querySelectAll()

    fun getSelectAllByLast() = dbOfMemo.memoDao().querySelectAllByLast()

    fun insertMemoData(memoEntity: MemoEntity) = dbOfMemo.memoDao().insert(memoEntity)

    fun updateMemoData(memoEntity: MemoEntity) = dbOfMemo.memoDao().update(memoEntity)

    fun deleteMemoData(memoEntity: MemoEntity) = dbOfMemo.memoDao().delete(memoEntity)
}