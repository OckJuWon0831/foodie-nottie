package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityFavoriteBinding
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivitySearchBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        binding.logoutBtn.setOnClickListener {
            Firebase.auth.signOut()
            startActivity(Intent(this, IntroActivity::class.java))
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
    }


}