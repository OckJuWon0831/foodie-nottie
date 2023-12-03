package com.example.myapplication.dto

import java.io.Serializable

data class Memo(
    val title : String,
    val content : String,
    val createdDate : String?
) : Serializable