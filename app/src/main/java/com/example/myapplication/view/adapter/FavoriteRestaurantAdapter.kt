package com.example.myapplication.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.BuildConfig
import com.example.myapplication.R
import com.example.myapplication.db.entity.RestaurantWithPhoto

class FavoriteRestaurantAdapter(val context : Context, val dataset: List<RestaurantWithPhoto>)
    :RecyclerView.Adapter<FavoriteRestaurantAdapter.ViewHolder>() {

        inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
            val restaurantName = view.findViewById<TextView>(R.id.tvTitle)
            val restaurantStatus = view.findViewById<TextView>(R.id.tvBusinessStatus)
            val restaurantTotalRate = view.findViewById<TextView>(R.id.tvUserRatingsTotal)
            val restaurantVicinity = view.findViewById<TextView>(R.id.tvVicinity)
            val restaurantImage: ImageView = view.findViewById(R.id.ivThumbnail)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favorite_restaurant_item, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.restaurantName.text = dataset[position].restaurant.name
        holder.restaurantStatus.text = dataset[position].restaurant.businessStatus
        holder.restaurantTotalRate.text = dataset[position].restaurant.userRatingsTotal.toString()
        holder.restaurantVicinity.text = dataset[position].restaurant.vicinity
        val photoReference = dataset[position].photo.photoReference

        val api = BuildConfig.GOOGLE_MAP_API_KEY

        val imageUrl = "https://maps.googleapis.com/maps/api/place/photo" +
                "?maxheight=400&maxwidth=400&photoreference=$photoReference&key=$api"

        Glide.with(context)
            .load(imageUrl)
            .centerCrop()
            .placeholder(R.drawable.restaurant)
            .into(holder.restaurantImage)
    }
}