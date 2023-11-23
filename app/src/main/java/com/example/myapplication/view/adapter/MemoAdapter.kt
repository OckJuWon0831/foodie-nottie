package com.example.myapplication.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.MemoItemBinding
import com.example.myapplication.dto.Memo
import java.util.*

class MemoAdapter(private var memo: Vector<Memo>, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = MemoItemBinding.inflate(LayoutInflater.from(context),parent, false)
        return ItemHoder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemHolder = holder as ItemHoder
        val binding = itemHolder.binding
        val pos = (memo.size - 1) - position
        binding.memoTitleTv.text = memo[pos].title
        val time = "Written date: " + memo[pos].createdDate
        binding.noteDateTv.text = time

    }

    override fun getItemCount(): Int {
        return memo.size
    }

    class ItemHoder : RecyclerView.ViewHolder {
        var binding: MemoItemBinding

        constructor(binding: MemoItemBinding) : super(binding.root) {
            this.binding = binding
        }
    }
}