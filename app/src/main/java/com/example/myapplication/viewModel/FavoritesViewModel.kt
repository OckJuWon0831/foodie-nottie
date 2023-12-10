package com.example.myapplication.viewModel

import android.graphics.Bitmap
import androidx.lifecycle.*
import com.example.myapplication.db.entity.RestaurantWithPhoto
import com.example.myapplication.repository.DBRepository
import com.example.myapplication.repository.NetworkRepository
import kotlinx.coroutines.launch

class FavoritesViewModel : ViewModel() {

    private val dbRepository = DBRepository()
    lateinit var selectedRestaurantList: LiveData<List<RestaurantWithPhoto>>

    fun getAllInterestedRestaurants() = viewModelScope.launch {
        selectedRestaurantList = dbRepository.getRestaurantSelectedData().asLiveData()
    }

}