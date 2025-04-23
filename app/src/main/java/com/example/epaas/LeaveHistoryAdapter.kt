package com.example.epaas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.safehostel.LeaveEntry
import com.safehostel.R

class LeaveHistoryAdapter(private val leaveList: List<LeaveEntry>) :
    RecyclerView.Adapter<LeaveHistoryAdapter.LeaveViewHolder>() {

    class LeaveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val studentText: TextView = itemView.findViewById(R.id.tv_student)
        val dateText: TextView = itemView.findViewById(R.id.tv_date)
        val reasonText: TextView = itemView.findViewById(R.id.tv_reason)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaveViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_leave_history_adapter, parent, false) // Updated to use item_leave_history.xml
        return LeaveViewHolder(view)
    }

    override fun onBindViewHolder(holder: LeaveViewHolder, position: Int) {
        val entry = leaveList[position]
        holder.studentText.text = "${entry.studentName} (${entry.rollNo})"
        holder.dateText.text = "Date: ${entry.leaveDate}"
        holder.reasonText.text = "Reason: ${entry.reason}"
    }

    override fun getItemCount() = leaveList.size
}
