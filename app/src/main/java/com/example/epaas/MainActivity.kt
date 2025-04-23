package com.safehostel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.epaas.LeaveHistoryActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences("UserCredentials", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (!isLoggedIn) {
            startActivity(Intent(this, com.example.epaas.LoginActivity::class.java))
            finish()
        } else {
            setContentView(R.layout.activity_main)

            val studentButton = findViewById<Button>(R.id.studentButton)
            val wardenButton = findViewById<Button>(R.id.wardenButton)
            val historyButton = findViewById<Button>(R.id.btn_view_history)

            studentButton.setOnClickListener {
                startActivity(Intent(this, StudentActivity::class.java))
            }

            wardenButton.setOnClickListener {
                startActivity(Intent(this, WardenActivity::class.java))
            }

            historyButton.setOnClickListener {
                startActivity(Intent(this, LeaveHistoryActivity::class.java))
            }
        }
    }
}
