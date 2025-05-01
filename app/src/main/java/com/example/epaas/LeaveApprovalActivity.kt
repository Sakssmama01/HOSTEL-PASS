package com.safehostel
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.safehostel.MainActivity
import com.safehostel.R

class LeaveApprovalActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var rollNoTextView: TextView
    private lateinit var leaveDateTextView: TextView
    private lateinit var reasonTextView: TextView
    private lateinit var statusTextView: TextView
    private lateinit var backToMainMenuButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leave_approval)

        // Initialize views
        nameTextView = findViewById(R.id.tv_name)
        rollNoTextView = findViewById(R.id.tv_roll_no)
        leaveDateTextView = findViewById(R.id.tv_leave_date)
        reasonTextView = findViewById(R.id.tv_reason)
        statusTextView = findViewById(R.id.tv_status)
        backToMainMenuButton = findViewById(R.id.btn_back_to_main_menu)

        // Retrieve data passed from ApplyLeaveActivity
        val name = intent.getStringExtra("NAME")
        val rollNo = intent.getStringExtra("ROLL_NO")
        val leaveDate = intent.getStringExtra("LEAVE_DATE")
        val reason = intent.getStringExtra("REASON")

        // Set the retrieved data to the corresponding views
        nameTextView.text = "Name: $name"
        rollNoTextView.text = "Roll No: $rollNo"
        leaveDateTextView.text = "Leave Date: $leaveDate"
        reasonTextView.text = "Reason: $reason"

        // Optionally, set the approval status (e.g., "Approved" or "Pending")
        statusTextView.text = "Status: Approved"
        statusTextView.setTextColor(resources.getColor(R.color.green))

        // Set an onClickListener for the button to navigate back to the main menu or activity
        backToMainMenuButton.setOnClickListener {
            // Intent to navigate back to the MainActivity (or any other activity you want)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // Finish the current activity so the user can't go back to it by pressing the back button
        }
    }
}
