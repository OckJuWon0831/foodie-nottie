package com.example.myapplication.view.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.myapplication.view.main.MainActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityJoinBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_join)
        auth = Firebase.auth

        binding.joinBtn.setOnClickListener {
            var joinFlag = true
            val name = binding.signinName.text.toString()
            val email = binding.signinEmail.text.toString()
            val password = binding.signinPassword.text.toString()
            val password2 = binding.signinPasswordCheck.text.toString()

            if (name.isEmpty()) {
                Toast.makeText(this, "Name is required", Toast.LENGTH_LONG).show()
                joinFlag = false
            }

            if (email.isEmpty()) {
                Toast.makeText(this, "Email is required", Toast.LENGTH_LONG).show()
                joinFlag = false
            }

            if (password.isEmpty()) {
                Toast.makeText(this, "Password is required", Toast.LENGTH_LONG).show()
                joinFlag = false
            }

            if (password2.isEmpty()) {
                Toast.makeText(this, "Password Checking must required", Toast.LENGTH_LONG).show()
                joinFlag = false
            }

            if (!password.equals(password2)) {
                Toast.makeText(this, "Password must be the same", Toast.LENGTH_LONG).show()
                joinFlag = false
            }

            if (password.length < 6) {
                Toast.makeText(this, "Password must be longer than 6 characters", Toast.LENGTH_LONG).show()
                joinFlag = false
            }

            if (joinFlag) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Your account has been created", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }

    }
}