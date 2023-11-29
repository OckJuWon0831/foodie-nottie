package com.example.myapplication.viewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.MemoDBRepository

class MemoViewModel : ViewModel() {
    private val memoRepository = MemoDBRepository()
}