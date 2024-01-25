package com.example.pro

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginsignupsql.UserHelper
import com.example.pro.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseHelper: UserHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logbutton.setOnClickListener {
            val logname = binding.lsuemail.text.toString()
            val logpassword = binding.lsupassword.text.toString()
            loginDatabase(logname, logpassword)
        }
        binding.signupRedirectText.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
        databaseHelper = UserHelper(this)
    }

    private fun loginDatabase(username: String, password: String) {
        val userExists = databaseHelper.readUser(username, password)
        if (userExists) {
            Toast.makeText(this, "login Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}