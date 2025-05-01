package com.safehostel

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.safehostel.R
import java.util.Calendar

class ApplyLeaveActivity : AppCompatActivity() {

    private lateinit var etDate: EditText
    private lateinit var etStudentName: EditText
    private lateinit var etRollNo: EditText
    private lateinit var etLeaveReason: EditText
    private lateinit var btnSubmitLeave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_leave)

        // Initialize views
        etDate = findViewById(R.id.et_date)
        etStudentName = findViewById(R.id.et_name)
        etRollNo = findViewById(R.id.et_roll)
        etLeaveReason = findViewById(R.id.et_reason)
        btnSubmitLeave = findViewById(R.id.btn_submit_leave)

        // Set a click listener for the date EditText to show the DatePickerDialog
        etDate.setOnClickListener {
            showDatePickerDialog()
        }

        // Set onClickListener for the Submit button
        btnSubmitLeave.setOnClickListener {
            val leaveDate = etDate.text.toString()
            val studentName = etStudentName.text.toString()
            val rollNo = etRollNo.text.toString()
            val leaveReason = etLeaveReason.text.toString()

            // Validate input fields
            if (leaveDate.isEmpty() || studentName.isEmpty() || rollNo.isEmpty() || leaveReason.isEmpty()) {
                Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_SHORT).show()
            } else {
                // Proceed with submitting the leave request and navigate to the confirmation screen
                navigateToLeaveConfirmation(studentName, rollNo, leaveDate, leaveReason)
            }
        }
    }

    private fun showDatePickerDialog() {
        // Get current date
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        // Create DatePickerDialog
        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                // Set selected date in the EditText
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                etDate.setText(selectedDate)
            },
            year,
            month,
            dayOfMonth
        )

        // Show the DatePickerDialog
        datePickerDialog.show()
    }

    // Function to navigate to LeaveConfirmationActivity
    private fun navigateToLeaveConfirmation(studentName: String, rollNo: String, leaveDate: String, leaveReason: String) {
        val intent = Intent(this, LeaveApprovalActivity::class.java) // Corrected Intent

        // Passing data to LeaveApprovalActivity
        intent.putExtra("NAME", studentName)
        intent.putExtra("ROLL_NO", rollNo)
        intent.putExtra("LEAVE_DATE", leaveDate)
        intent.putExtra("REASON", leaveReason)

        // Start the new activity
        startActivity(intent)

        // Optionally, finish the current activity to prevent going back to it
        finish()

        // Save leave data to SharedPreferences
        val sharedPreferences = getSharedPreferences("LeaveHistory", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val existingHistory = sharedPreferences.getString("leaves", "") ?: ""
        val newEntry = "$studentName|$rollNo|$leaveDate|$leaveReason"
        val updatedHistory = existingHistory + newEntry + ";;"  // separate entries with ;;
        editor.putString("leaves", updatedHistory)
        editor.apply()
    }
}
