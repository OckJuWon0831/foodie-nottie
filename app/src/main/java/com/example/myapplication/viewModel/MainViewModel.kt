package com.example.myapplication.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.dto.Restuarant
import com.example.myapplication.repository.NetworkRepository
import com.google.gson.Gson
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel : ViewModel() {

    private val networkRepository = NetworkRepository()
    private lateinit var restaurantsList : ArrayList<Restuarant>
    private val _restaurantsList = MutableLiveData<List<Restuarant>>()
    val updatedRestaurantList : LiveData<List<Restuarant>>
        get() = _restaurantsList

    fun getNearRestaurantList() = viewModelScope.launch {
        val restaurant = networkRepository.getNearRestaurantsList()
        restaurantsList = ArrayList()

        for (i : Int in 0..10) {
            try {
                val gson = Gson()
                val gsonToJson = gson.toJson(restaurant.results[i])
                val gsonRestuarant = gson.fromJson(gsonToJson, Restuarant::class.java)
                restaurantsList.add(gsonRestuarant)
                //Log.d("MainViewModel", gsonRestuarant.toString())
            } catch (e : java.lang.Exception) {
                //Timber.d(e.toString())
            }
        }

        _restaurantsList.value =  restaurantsList
    }
}