package com.safehostel
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class StudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        val applyForPassButton: Button = findViewById(R.id.btn_apply_leave)

        // Set the button click listener to navigate to ApplyLeaveActivity
        applyForPassButton.setOnClickListener {
            val intent = Intent(this, ApplyLeaveActivity::class.java)
            startActivity(intent)
        }
    }
}
