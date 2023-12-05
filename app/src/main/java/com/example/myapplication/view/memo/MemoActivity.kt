package com.example.myapplication.view.memo

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMemoBinding
import com.example.myapplication.view.adapter.MemoAdapter
import com.example.myapplication.viewModel.MemoViewModel
import timber.log.Timber

class MemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemoBinding
    private val viewModel : MemoViewModel by viewModels()
    private lateinit var memoAdapter : MemoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            viewModel.getMemoList()
        } catch (e: java.lang.Exception) {
            Timber.d(e.toString())
        }
        viewModel.updateMemoList.observe(this, Observer {
            memoAdapter = MemoAdapter(this, it)
            binding.mnMemoList.adapter = memoAdapter
            binding.mnMemoList.layoutManager = LinearLayoutManager(this)
        })

        binding.MainFabButtonFab.setOnClickListener {
            val intent = Intent(this, WriteActivity::class.java)
            startActivity(intent)
        }
    }
}