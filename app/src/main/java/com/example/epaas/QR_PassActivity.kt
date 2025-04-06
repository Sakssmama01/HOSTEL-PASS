package com.safehostel

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.safehostel.R
import java.text.SimpleDateFormat
import java.util.*

class QRPassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_pass)

        val statusText = findViewById<TextView>(R.id.tv_status)
        val dateTimeText = findViewById<TextView>(R.id.tv_datetime)

        val sdf = SimpleDateFormat("dd MMM yyyy - hh:mm a", Locale.getDefault())
        val currentDateTime = sdf.format(Date())

        statusText.text = "✅ You Are Approved!"
        dateTimeText.text = "Date & Time: $currentDateTime"
    }
}
