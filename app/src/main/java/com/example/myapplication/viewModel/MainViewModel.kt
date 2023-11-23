package com.example.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.dataModels.restaurant.Restaurant
import com.example.myapplication.repository.NetworkRepository
import com.google.gson.Gson
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val networkRepository = NetworkRepository()
    private lateinit var restaurantsList : ArrayList<Restaurant>
    private val _restaurantsList = MutableLiveData<List<Restaurant>>()
    val updatedRestaurantList : LiveData<List<Restaurant>>
        get() = _restaurantsList

    fun getNearRestaurantList() = viewModelScope.launch {
        val restaurant = networkRepository.getNearRestaurantsList()
        restaurantsList = ArrayList()

        for (i : Int in 0..10) {
            try {
                val gson = Gson()
                val gsonToJson = gson.toJson(restaurant.results[i])
                val gsonRestaurant = gson.fromJson(gsonToJson, Restaurant::class.java)
                restaurantsList.add(gsonRestaurant)
                //Log.d("MainViewModel", gsonRestuarant.toString())
            } catch (e : java.lang.Exception) {
                //Timber.d(e.toString())
            }
        }

        _restaurantsList.value =  restaurantsList
    }
}