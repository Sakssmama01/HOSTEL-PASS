package com.safehostel

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LeaveConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leave_confirmation)

        // Get the leave request details passed from ApplyLeaveActivity
        val studentName = intent.getStringExtra("STUDENT_NAME")
        val rollNo = intent.getStringExtra("ROLL_NO")
        val leaveDate = intent.getStringExtra("LEAVE_DATE")
        val leaveReason = intent.getStringExtra("LEAVE_REASON")

        // Find TextView to display the leave request details
        val confirmationTextView = findViewById<TextView>(R.id.tv_confirmation_message)

        // Set the message with the leave request details
        confirmationTextView.text = """
            Leave Request Submitted Successfully!
            
            Student Name: $studentName
            Roll No: $rollNo
            Leave Date: $leaveDate
            Reason: $leaveReason
        """.trimIndent()
    }
}
