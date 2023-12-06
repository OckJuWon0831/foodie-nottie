package com.example.myapplication.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.db.entity.RestaurantWithPhoto

class FavoriteRestaurantAdapter(val context : Context, val dataset: List<RestaurantWithPhoto>)
    :RecyclerView.Adapter<FavoriteRestaurantAdapter.ViewHolder>() {

        inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {



        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favorite_restaurant_item, parent, false)
        return  ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

}