package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.Window
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMemoBinding
import com.example.myapplication.viewModel.MemoViewModel
import java.text.SimpleDateFormat
import java.util.*

class MemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemoBinding
    private val viewModel : MemoViewModel by viewModels()


    private val format = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.MainFabButtonFab.setOnClickListener {
            val intent = Intent(this, WriteActivity::class.java)
            startActivity(intent)
        }

    }
}