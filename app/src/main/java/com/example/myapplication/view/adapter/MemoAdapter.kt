package com.example.myapplication.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.dto.Memo
import com.example.myapplication.view.EditMemoActivity
import com.example.myapplication.view.FavoriteActivity
import timber.log.Timber

class MemoAdapter(val context: Context, val memoList : List<Memo>)
    : RecyclerView.Adapter<MemoAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val memoTitle : TextView = view.findViewById(R.id.memoTitleTv)
            val memoCreatedDate : TextView = view.findViewById(R.id.noteDateTv)
            val memoItem : ConstraintLayout = view.findViewById(R.id.memoItem)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.memo_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return memoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.memoTitle.text = memoList[position].title
        holder.memoCreatedDate.text = memoList[position].createdDate.toString()

        holder.memoItem.setOnClickListener {
            val intent = Intent(context, EditMemoActivity::class.java)
            intent.putExtra("memo_dto", memoList[position])
            context.startActivity(intent)
        }
    }
}