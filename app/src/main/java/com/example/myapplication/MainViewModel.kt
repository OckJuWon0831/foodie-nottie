package com.example.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    fun test() {
        Log.d("MainViewModel","test")
    }
}