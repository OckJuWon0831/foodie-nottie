package com.example.myapplication.viewModel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.db.entity.MemoEntity
import com.example.myapplication.dto.Memo
import com.example.myapplication.dto.restaurant.Restaurant
import com.example.myapplication.repository.MemoDBRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class MemoViewModel : ViewModel() {
    private val memoRepository = MemoDBRepository()
    private lateinit var memoList : ArrayList<Memo>

    private val _memoList = MutableLiveData<List<Memo>>()
    val updateMemoList : LiveData<List<Memo>>
        get() = _memoList

    fun getMemoList() = viewModelScope.launch(Dispatchers.IO) {
        val memo = memoRepository.getSelectAllByLast()
        memoList = ArrayList()

        for (i in memo) {
            try {
                val memo = Memo(
                    i.title,
                    i.content,
                    i.createdDate
                )
                memoList.add(memo)
            } catch (e: java.lang.Exception) {
                Timber.d(e.toString())
            }
        }
        _memoList.postValue(memoList)
    }

    fun updateMemo(memo : Memo) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val memoEntity = MemoEntity(
                memoRepository.getIdByTitle(memo.title),
                memo.title,
                memo.content,
                memo.createdDate
            )
            memoRepository.updateMemoData(memoEntity)
        } catch (e: java.lang.Exception) {
            Timber.d(e.toString())
        }
    }

    fun insertMemo(memo: Memo) = viewModelScope.launch(Dispatchers.IO) {
            try {
                val memoEntity = MemoEntity(
                    0,
                    memo.title,
                    memo.content,
                    memo.createdDate
                )
                memoRepository.insertMemoData(memoEntity)
            } catch (e: java.lang.Exception) {
                Timber.d(e.toString())
            }
    }
}