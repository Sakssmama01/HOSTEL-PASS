package com.example.epaas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.safehostel.MainActivity
import com.safehostel.R
import com.safehostel.RegisterActivity

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
            val rollNo = rollNoEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (validateLogin(rollNo, password)) {
                val sharedPreferences = getSharedPreferences("UserCredentials", Context.MODE_PRIVATE)
                sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }

        registerHereButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun validateLogin(rollNo: String, password: String): Boolean {
        val sharedPreferences = getSharedPreferences("UserCredentials", Context.MODE_PRIVATE)
        val savedPassword = sharedPreferences.getString(rollNo, null)
        return savedPassword == password
    }
}
