package com.example.myapplication.view.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityFavoriteBinding
import com.example.myapplication.db.entity.RestaurantWithPhoto
import com.example.myapplication.view.IntroActivity
import com.example.myapplication.view.adapter.FavoriteRestaurantAdapter
import com.example.myapplication.view.adapter.MainRestaurantAdapter
import com.example.myapplication.viewModel.FavoritesViewModel
import com.example.myapplication.viewModel.MainViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import timber.log.Timber

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFavoriteBinding
    private val viewModel : FavoritesViewModel by viewModels()
    private val selectedList = ArrayList<RestaurantWithPhoto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getAllInterestedRestaurants()
        viewModel.selectedRestaurantList.observe(this, Observer {
            selectedList.clear()
            for (item in it) {
                if(item.restaurant.selected) {
                    selectedList.add(item)
                }
            }
            val favoriteRestaurantAdapter = FavoriteRestaurantAdapter(this, selectedList)
            binding.mnFavoriteRestaurantList.adapter = favoriteRestaurantAdapter
            binding.mnFavoriteRestaurantList.layoutManager = LinearLayoutManager(this)
        })

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