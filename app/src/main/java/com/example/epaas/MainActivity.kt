package com.safehostel

import android.content.Intent  // Import this
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the buttons by ID
        val studentButton = findViewById<Button>(R.id.studentButton)
        val wardenButton = findViewById<Button>(R.id.wardenButton)

        // Set onClickListeners for the buttons
        studentButton.setOnClickListener {
            // Navigate to StudentActivity
            val intent = Intent(this, StudentActivity::class.java)
            startActivity(intent)
        }

        wardenButton.setOnClickListener {
            // Navigate to WardenActivity
            val intent = Intent(this, WardenActivity::class.java)
            startActivity(intent)
        }
    }
}
