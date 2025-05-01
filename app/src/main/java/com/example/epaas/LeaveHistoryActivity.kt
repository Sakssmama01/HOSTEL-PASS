package com.safehostel

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LeaveHistoryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LeaveHistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leave_history)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerViewLeaveHistory)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Load dummy leave history data (you can replace this with real data later)
        val leaveHistoryList = listOf(
            LeaveEntry("Rajiv Mishra", "GU123", "2025-04-24", "Family Emergency"),
            LeaveEntry("Deepak kumar ", "GU124", "2025-04-22", "Medical Checkup"),
            LeaveEntry("Gaurav Tomar", "GU125", "2025-04-20", "Personal Work")
        )

        // Attach adapter

        adapter = LeaveHistoryAdapter(leaveHistoryList)
        recyclerView.adapter = adapter

        // Optional: show toast when data is loaded
        Toast.makeText(this, "Leave history loaded!", Toast.LENGTH_SHORT).show()
    }

}

