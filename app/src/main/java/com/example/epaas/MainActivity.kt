package com.safehostel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to the buttons
        val studentButton = findViewById<Button>(R.id.studentButton)
        val wardenButton = findViewById<Button>(R.id.wardenButton)
        val historyButton = findViewById<Button>(R.id.btn_view_history)

        // Set OnClickListener for the buttons
        studentButton.setOnClickListener {
            startActivity(Intent(this, StudentActivity::class.java))
        }

        wardenButton.setOnClickListener {
            startActivity(Intent(this, WardenActivity::class.java))
        }

        // When "View History" is clicked, go to LeaveHistoryActivity
        historyButton.setOnClickListener {
            startActivity(Intent(this, LeaveHistoryActivity::class.java))
        }
    }
}
