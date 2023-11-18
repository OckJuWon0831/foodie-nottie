package com.example.myapplication.view.fragments

import android.content.Intent
import  android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.view.FavoriteActivity
import com.example.myapplication.view.IntroActivity
import com.example.myapplication.view.MainActivity
import com.example.myapplication.view.MemoActivity
import com.example.myapplication.view.SplashActivity

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.homeTap.setOnClickListener {
            val intent = Intent(requireContext(), SplashActivity::class.java)
            startActivity(intent)
        }

        binding.favoriteTap.setOnClickListener {
            val intent = Intent(requireContext(), FavoriteActivity::class.java)
            startActivity(intent)
        }

        binding.memoTap.setOnClickListener {
            val intent = Intent(requireContext(), MemoActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

}