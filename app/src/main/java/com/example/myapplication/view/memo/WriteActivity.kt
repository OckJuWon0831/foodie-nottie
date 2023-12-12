package com.example.myapplication.view.memo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityWriteBinding
import com.example.myapplication.dto.Memo
import com.example.myapplication.viewModel.MemoViewModel
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

class WriteActivity : AppCompatActivity() {
    private val viewModel: MemoViewModel by viewModels()
    private val formatOfTime = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
    private lateinit var binding : ActivityWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitBtn.setOnClickListener {
            try {
                val title = binding.titleEt.text.toString()
                val content = binding.todoContentEt.text.toString()

                if(title.trim().isEmpty() || content.trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please insert your memo.",Toast.LENGTH_SHORT).show()
                }
                else {
                    val memo = Memo(
                        title,
                        content,
                        formatOfTime.format(System.currentTimeMillis()).toString()
                    )
                    viewModel.insertMemo(memo)
                    finish()
                    startActivity(Intent(this, MemoActivity::class.java))
                }
            } catch (e: java.lang.Exception) {
                Timber.d(e.toString())
            }
        }

    }
}