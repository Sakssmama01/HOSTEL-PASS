package com.safehostel


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LeaveHistoryAdapter(private val leaveList: List<LeaveEntry>) :
    RecyclerView.Adapter<LeaveHistoryAdapter.LeaveViewHolder>() {

    // ViewHolder to hold views for each item
    class LeaveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val studentText: TextView = itemView.findViewById(R.id.tv_student)
        val dateText: TextView = itemView.findViewById(R.id.tv_date)
        val reasonText: TextView = itemView.findViewById(R.id.tv_reason)
    }

    // Creates the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaveViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_leave_history_adapter, parent, false)  // Layout for each item
        return LeaveViewHolder(view)
    }

    // Binds data to each item in the RecyclerView
    override fun onBindViewHolder(holder: LeaveViewHolder, position: Int) {
        val entry = leaveList[position]
        holder.studentText.text = "${entry.studentName} (${entry.rollNo})"
        holder.dateText.text = "Date: ${entry.leaveDate}"
        holder.reasonText.text = "Reason: ${entry.reason}"
    }

    override fun getItemCount() = leaveList.size
}
