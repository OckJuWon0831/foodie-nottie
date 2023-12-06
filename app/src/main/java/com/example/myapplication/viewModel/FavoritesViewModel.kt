package com.example.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.db.entity.RestaurantWithPhoto
import com.example.myapplication.repository.DBRepository
import kotlinx.coroutines.launch

class FavoritesViewModel : ViewModel() {

    private val dbRepository = DBRepository()
    lateinit var selectedRestaurantList: LiveData<List<RestaurantWithPhoto>>

    fun getAllInterestedRestaurants() = viewModelScope.launch {
        selectedRestaurantList = dbRepository.getRestaurantSelectedData().asLiveData()
    }
}