package com.safehostel

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    // Remove FirebaseAuth reference as it's not needed
    // private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize the UI elements
        val email = findViewById<EditText>(R.id.et_register_email)
        val password = findViewById<EditText>(R.id.et_register_password)
        val registerBtn = findViewById<Button>(R.id.btn_register)
        val loginLink = findViewById<TextView>(R.id.tv_login_link)

        registerBtn.setOnClickListener {
            val userEmail = email.text.toString()
            val userPass = password.text.toString()

            if (userEmail.isNotEmpty() && userPass.isNotEmpty()) {
                // Save the registration data locally, e.g., using SharedPreferences or in-memory data
                saveUserData(userEmail, userPass)

                Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show()

                // Redirect to MainActivity or LoginActivity (depending on your flow)
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        loginLink.setOnClickListener {
            // Navigate to LoginActivity
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    // Function to simulate saving the user data (e.g., using SharedPreferences)
    private fun saveUserData(email: String, password: String) {
        // For example, you could store the data in SharedPreferences
        val sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("email", email)
        editor.putString("password", password)
        editor.apply()
    }
}
