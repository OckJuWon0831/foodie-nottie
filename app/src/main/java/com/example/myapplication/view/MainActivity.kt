package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.view.adapter.MainRestaurantAdapter
import com.example.myapplication.viewModel.MainViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.*

class MainActivity : AppCompatActivity() {
    private val viewModel : MainViewModel by viewModels()
    private lateinit var mainRestaurantAdapter: MainRestaurantAdapter
    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getNearRestaurantList()
        viewModel.updatedRestaurantList.observe(this, Observer {
            mainRestaurantAdapter = MainRestaurantAdapter(this, it)
            binding.mnRestaurantList.adapter = mainRestaurantAdapter
            binding.mnRestaurantList.layoutManager = LinearLayoutManager(this)
        })

        binding.checkbox.setOnClickListener {
            viewModel.saveSelectedRestaurantList(mainRestaurantAdapter.selectedRestaurantList)
        }

        binding.logoutBtn.setOnClickListener {
            Firebase.auth.signOut()
            startActivity(Intent(this, IntroActivity::class.java))
        }

        viewModel.save.observe(this, Observer {
            if(it.equals("done")) {
                val intent = Intent(this, FavoriteActivity::class.java)
                startActivity(intent)
            }
        })
    }
}
