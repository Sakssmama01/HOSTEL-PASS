package com.safehostel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.safehostel.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val applyLeaveButton = findViewById<Button>(R.id.btn_apply_leave)
        applyLeaveButton.setOnClickListener {
            startActivity(Intent(this, LeaveRequestActivity::class.java))
        }
    }
}
