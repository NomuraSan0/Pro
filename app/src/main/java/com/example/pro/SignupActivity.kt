package com.example.pro

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginsignupsql.UserHelper
import com.example.pro.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var databaseHelper: UserHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = UserHelper(this)

        binding.sigbutton.setOnClickListener {
            val signupUsername = binding.suemail.text.toString()
            val signupPassword = binding.supassword.text.toString()
            signupDatabase(signupUsername, signupPassword)
        }
        binding.loginRedirectText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
    }
}
        private fun signupDatabase (username: String, password: String){
        val insertedRowId = databaseHelper. insertUser(username, password)
        if (insertedRowId != -1L) {
            Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(  this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText (this, "Signup Failed", Toast.LENGTH_SHORT).show()
}
}}