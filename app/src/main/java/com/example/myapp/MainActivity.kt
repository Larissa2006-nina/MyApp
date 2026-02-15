package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.databinding.ActivityLoginBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val email = binding.email.text.toString().trim()
            val phone = binding.phone.text.toString().trim()
            val gender = binding.gender.text.toString().trim()
            val password = binding.password.text.toString().trim()
            
            // Basic Validation
            var isValid = true

            if (email.isEmpty()) {
                binding.email.error = "Email is required"
                isValid = false
            }

            if (phone.isEmpty()) {
                binding.phone.error = "Phone number is required"
                isValid = false
            }

            if (gender.isEmpty()) {
                binding.gender.error = "Gender is required"
                isValid = false
            } else if (!gender.equals("male", ignoreCase = true) && !gender.equals("female", ignoreCase = true)) {
                binding.gender.error = "Please refill"
                Toast.makeText(this, "Please refill", Toast.LENGTH_SHORT).show()
                isValid = false
            }

            if (password.isEmpty()) {
                binding.password.error = "Password is required"
                isValid = false
            }

            if (isValid) {
                // Show loading and proceed
                binding.loading.visibility = View.VISIBLE
                binding.loginButton.isEnabled = false

                // Transition to LandingActivity
                val intent = Intent(this, LandingActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        binding.signupButton.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
        }
    }
}
