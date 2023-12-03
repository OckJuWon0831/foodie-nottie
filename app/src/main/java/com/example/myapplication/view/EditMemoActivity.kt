package com.example.myapplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil.setContentView
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityEditMemoBinding
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.dto.Memo
import com.example.myapplication.viewModel.MainViewModel
import com.example.myapplication.viewModel.MemoViewModel
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

class EditMemoActivity : AppCompatActivity() {
    private val viewModel : MemoViewModel by viewModels()
    private lateinit var binding : ActivityEditMemoBinding

    private val formatOfTime = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        try {
            val receivedMemo = intent.getSerializableExtra("memo_dto") as? Memo
            binding.originalTitleTv.text = receivedMemo?.title
            binding.titleEt.hint = receivedMemo?.title
            binding.todoContentEt.hint = receivedMemo?.content
        } catch (e: java.lang.Exception) {
            Timber.d(e.toString())
        }

        binding.editBtn.setOnClickListener {
            try {
                val title = binding.titleEt.text.toString()
                val content = binding.todoContentEt.text.toString()

                if(title.trim().isEmpty() || content.trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please insert your memo if you want to edit.",Toast.LENGTH_SHORT).show()
                }
                else {
                    val memo = Memo(
                        title,
                        content,
                        formatOfTime.format(System.currentTimeMillis()).toString()
                    )
                    viewModel.updateMemo(memo)
                    finish()
                    startActivity(Intent(this, MemoActivity::class.java))
                }
            } catch (e: java.lang.Exception) {
                Timber.d(e.toString())
            }
        }

    }
}