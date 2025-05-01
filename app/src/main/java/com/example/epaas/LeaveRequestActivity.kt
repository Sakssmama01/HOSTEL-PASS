package com.safehostel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.safehostel.R

class LeaveRequestActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var rollNoEditText: EditText
    private lateinit var dateEditText: EditText
    private lateinit var reasonEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leave_request)

        nameEditText = findViewById(R.id.et_name)
        rollNoEditText = findViewById(R.id.et_roll)
        dateEditText = findViewById(R.id.et_date)
        reasonEditText = findViewById(R.id.et_reason)
        submitButton = findViewById(R.id.btn_submit_leave)

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val rollNo = rollNoEditText.text.toString()
            val leaveDate = dateEditText.text.toString()
            val reason = reasonEditText.text.toString()

            if (name.isNotEmpty() && rollNo.isNotEmpty() && leaveDate.isNotEmpty() && reason.isNotEmpty()) {
                val intent = Intent(this, LeaveApprovalActivity::class.java).apply {
                    putExtra("NAME", name)
                    putExtra("ROLL_NO", rollNo)
                    putExtra("LEAVE_DATE", leaveDate)
                    putExtra("REASON", reason)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
