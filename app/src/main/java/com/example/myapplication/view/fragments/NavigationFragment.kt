package com.example.myapplication.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentNavigationBinding
import com.example.myapplication.view.main.FavoriteActivity
import com.example.myapplication.view.main.MainActivity
import com.example.myapplication.view.memo.MemoActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class NavigationFragment : Fragment() {
    private lateinit var binding: FragmentNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_navigation, container, false)
        binding.homeTap.setOnClickListener {
            if(Firebase.auth.currentUser?.uid != null) {
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
            }
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