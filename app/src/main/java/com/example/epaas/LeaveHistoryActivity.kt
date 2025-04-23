package com.example.epaas

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.safehostel.LeaveEntry
import com.safehostel.R

class LeaveHistoryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LeaveHistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leave_history)

        recyclerView = findViewById(R.id.recyclerViewHistory)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val sharedPreferences = getSharedPreferences("LeaveHistory", Context.MODE_PRIVATE)
        val historyData = sharedPreferences.getString("leaves", "") ?: ""
        val entries = historyData.split(";;").filter { it.isNotBlank() }

        val leaveList = entries.map {
            val parts = it.split("|")
            LeaveEntry(parts[0], parts[1], parts[2], parts[3])
        }

        adapter = LeaveHistoryAdapter(leaveList)
        recyclerView.adapter = adapter
    }
}
