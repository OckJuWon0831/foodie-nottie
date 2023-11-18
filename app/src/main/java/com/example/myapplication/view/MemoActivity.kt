package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityMemoBinding
import com.example.myapplication.sqlite.MemoOpenHelper
import java.text.SimpleDateFormat
import java.util.*

class MemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemoBinding

    private val format = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goMainIv.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.addNoteIv.setOnClickListener {
            val title = binding.titleEt.text
            val content = binding.todoContentEt.text

            if (title == null && content == null) {
                Toast.makeText(this, "Insert the title and contents.", Toast.LENGTH_SHORT).show()

            } else {
                val time = format.format(Date())
                val db = MemoOpenHelper(this).writableDatabase
                db.execSQL("insert into memo values (\'$title\', \'$content\', \'$time\')")
                db.close()
                Toast.makeText(this, "Memo has been uploaded.", Toast.LENGTH_SHORT).show()
                onBackPressed()
            }
        }
    }
}