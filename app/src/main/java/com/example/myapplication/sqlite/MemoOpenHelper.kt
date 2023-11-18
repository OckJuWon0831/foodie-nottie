package com.example.myapplication.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build.VERSION


class MemoOpenHelper(context : Context) : SQLiteOpenHelper(context, "memo.db", null, VERSION) {
    companion object {
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "create table memo(" +
                "title varchar(100) not null," +
                "content text not null," +
                "write_date char(10) not null" +
                ");"
        db?.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented")
    }
}