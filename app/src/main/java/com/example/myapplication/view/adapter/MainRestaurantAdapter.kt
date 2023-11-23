package com.example.myapplication.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.dataModels.Restuarant

class MainRestaurantAdapter(val context: Context, val restaurantsList : List<Restuarant>)
    :RecyclerView.Adapter<MainRestaurantAdapter.ViewHolder>() {

        val selectedRestaurantList = ArrayList<String>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val restuarantName : TextView = view.findViewById(R.id.tvTitle)
        val restuarantRating : TextView = view.findViewById(R.id.tvScore)
        val restuarantItem : ConstraintLayout = view.findViewById(R.id.restaurantItem)
        val favoriteIcon : ImageView = view.findViewById(R.id.ivFavorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_restaurant_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return restaurantsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.restuarantName.text = restaurantsList[position].name
        holder.restuarantRating.text = restaurantsList[position].rating.toString()

        val currentRestaurant = restaurantsList[position].name

        holder.restuarantItem.setOnClickListener {
            if (!holder.favoriteIcon.isVisible && !selectedRestaurantList.contains(currentRestaurant)) {
                holder.favoriteIcon.isVisible = true
                selectedRestaurantList.add(currentRestaurant)
            } else if (holder.favoriteIcon.isVisible) {
                holder.favoriteIcon.isVisible = false
                selectedRestaurantList.remove(currentRestaurant)
            }
        }
    }

}