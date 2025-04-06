package com.safehostel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.safehostel.R

class LeaveRequestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leave_request)

        val etDate = findViewById<EditText>(R.id.et_leave_date)
        val etReason = findViewById<EditText>(R.id.et_leave_reason)
        val btnSubmit = findViewById<Button>(R.id.btn_submit_leave)

        btnSubmit.setOnClickListener {
            val date = etDate.text.toString()
            val reason = etReason.text.toString()

            if (date.isNotEmpty() && reason.isNotEmpty()) {
                Toast.makeText(this, "Leave Request Sent", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, QRPassActivity::class.java))
            } else {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
