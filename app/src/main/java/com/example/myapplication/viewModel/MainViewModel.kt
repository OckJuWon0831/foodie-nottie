package com.example.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.db.entity.FavoriteRestaurantEntity
import com.example.myapplication.dto.restaurant.Restaurant
import com.example.myapplication.repository.DBRepository
import com.example.myapplication.repository.NetworkRepository
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class MainViewModel : ViewModel() {

    private val networkRepository = NetworkRepository()
    private lateinit var restaurantsList : ArrayList<Restaurant>
    private val dbRepository = DBRepository()

    private val _restaurantsList = MutableLiveData<List<Restaurant>>()
    val updatedRestaurantList : LiveData<List<Restaurant>>
        get() = _restaurantsList

    private val _saved = MutableLiveData<String>()
    val save : LiveData<String>
        get() = _saved

    fun getNearRestaurantList() = viewModelScope.launch {
        val restaurant = networkRepository.getNearRestaurantsList()
        restaurantsList = ArrayList()

        for (i: Int in 0..10) {
            try {
                val gson = Gson()
                val gsonToJson = gson.toJson(restaurant.results[i])
                val gsonRestaurant = gson.fromJson(gsonToJson, Restaurant::class.java)
                restaurantsList.add(gsonRestaurant)
//                Timber.d(gsonRestaurant.toString())
            } catch (e: java.lang.Exception) {
                Timber.d(e.toString())
            }
        }
        _restaurantsList.value = restaurantsList
    }

//    fun saveSelectedRestaurantList(selectedRestaurantList: ArrayList<String>) = viewModelScope.launch(Dispatchers.IO) {
//        for (restaurant in restaurantsList) {
//            val selected = selectedRestaurantList.contains(restaurant.name)
//            val favoriteRestaurantEntity = RestaurantWithPhoto(
//                //
//            )
//            favoriteRestaurantEntity.let {
//                dbRepository.insertRestaurantData(it)
//            }
//        }
//        withContext(Dispatchers.Main){
//            _saved.value = "done"
//        }
//    }
}