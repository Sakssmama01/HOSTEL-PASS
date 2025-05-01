package com.safehostel


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var rollNoEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerHereButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        rollNoEditText = findViewById(R.id.et_roll_no)
        passwordEditText = findViewById(R.id.et_password)
        loginButton = findViewById(R.id.btn_login)
        registerHereButton = findViewById(R.id.btn_register_here)

        loginButton.setOnClickListener {
            val rollNo = rollNoEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (validateLogin(rollNo, password)) {
                // Successful login
                val sharedPreferences = getSharedPreferences("UserCredentials", Context.MODE_PRIVATE)
                sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Close login activity
            } else {
                // Invalid credentials
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }

        registerHereButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun validateLogin(rollNo: String, password: String): Boolean {
        if (rollNo.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter both roll number and password", Toast.LENGTH_SHORT).show()
            return false
        }

        val sharedPreferences = getSharedPreferences("UserCredentials", Context.MODE_PRIVATE)

        // Log the rollNo and password for debugging
        Log.d("LoginActivity", "Validating login for rollNo: $rollNo")

        val savedPassword = sharedPreferences.getString(rollNo, null)
        if (savedPassword == null) {
            Log.d("LoginActivity", "No password found for rollNo: $rollNo")
        }

        // Validate if saved password matches entered password
        return savedPassword == password
    }
}
