package com.example.myapplication.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.dataModel.Restuarant

class MainRestaurantAdapter(val context: Context, val restaurantsList : List<Restuarant>)
    :RecyclerView.Adapter<MainRestaurantAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val restuarantName : TextView = view.findViewById(R.id.tvTitle)

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
    }

}