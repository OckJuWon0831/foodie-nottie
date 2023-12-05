package com.example.myapplication.view

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.example.myapplication.databinding.ActivitySearchBinding
import com.example.myapplication.view.adapter.MainRestaurantAdapter
import timber.log.Timber

class SearchActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySearchBinding
    private lateinit var mainRestaurantAdapter: MainRestaurantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSearchView()
    }

    private fun initSearchView() {
        binding.searchBar.isSubmitButtonEnabled = true

        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }
            override fun onQueryTextChange(s: String): Boolean {
//                mainRestaurantAdapter.getFilter().filter(s)
                Timber.d(TAG, "SearchView's Text is changed : $s")
                return false
            }
        })
    }

    override fun onBackPressed() {
        if (!binding.searchBar.isIconified) {
            binding.searchBar.isIconified = true
        } else {
            super.onBackPressed()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}


