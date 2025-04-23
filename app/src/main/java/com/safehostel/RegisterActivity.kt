package com.safehostel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.epaas.LoginActivity
import com.safehostel.R

class RegisterActivity : AppCompatActivity() {

    private lateinit var rollNoEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        rollNoEditText = findViewById(R.id.et_roll_no)
        passwordEditText = findViewById(R.id.et_password)
        registerButton = findViewById(R.id.btn_register)

        registerButton.setOnClickListener {
            val rollNo = rollNoEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (rollNo.isNotEmpty() && password.isNotEmpty()) {
                val sharedPreferences = getSharedPreferences("UserCredentials", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString(rollNo, password)
                editor.apply()

                Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()

                // After successful registration, go to LoginActivity
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
