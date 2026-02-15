package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val emailEditText = findViewById<EditText>(R.id.editTextTextEmailAddress2)
        val phoneEditText = findViewById<EditText>(R.id.editTextPhone2)
        val genderEditText = findViewById<EditText>(R.id.editTextText)
        val passwordEditText = findViewById<EditText>(R.id.editTextTextPassword2)
        val signupButton = findViewById<Button>(R.id.button)

        signupButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            val gender = genderEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            var isValid = true

            if (email.isEmpty()) {
                emailEditText.error = "Email is required"
                isValid = false
            }
            if (phone.isEmpty()) {
                phoneEditText.error = "Phone number is required"
                isValid = false
            }
            if (gender.isEmpty()) {
                genderEditText.error = "Gender is required"
                isValid = false
            } else if (!gender.equals("male", ignoreCase = true) && !gender.equals("female", ignoreCase = true)) {
                genderEditText.error = "Please refill"
                Toast.makeText(this, "Please refill", Toast.LENGTH_SHORT).show()
                isValid = false
            }
            if (password.isEmpty()) {
                passwordEditText.error = "Password is required"
                isValid = false
            }

            if (isValid) {
                val intent = Intent(this, LandingActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
