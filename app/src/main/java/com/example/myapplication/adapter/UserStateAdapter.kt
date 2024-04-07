package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.UserStateProfile
import com.squareup.picasso.Picasso

class UserStateAdapter(
    private val userList: MutableList<UserStateProfile>,
    private val listener: OnUserStateActionListener
) : RecyclerView.Adapter<UserStateAdapter.ViewHolder>() {

    fun updateUsers(users: List<UserStateProfile>) {
        userList.clear()
        userList.addAll(users)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        Picasso.get().load(user.picture).error(R.color.placeholder)
            .placeholder(R.color.placeholder).into(holder.imageView)
        holder.nameTextView.text = "${user.firstName} ${user.lastName}"
        user.age?.let {
            holder.ageTextView.isVisible = true
            holder.ageTextView.text = "Age: $it"
        }
        holder.locationTextView.text = "From ${user.city}, ${user.country}"
        holder.acceptButton.isVisible = false
        holder.declineButton.text = "Remove Profile"
        holder.statusTextView.apply {
            isVisible = true
            text = if (user.status) "Status: ACCEPTED" else "Status: DECLINED"
        }
        holder.declineButton.setOnClickListener {
            listener.onRemove(user)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    interface OnUserStateActionListener {
        fun onRemove(user: UserStateProfile)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.profileImage)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val locationTextView: TextView = itemView.findViewById(R.id.locationTextView)
        val statusTextView: TextView = itemView.findViewById(R.id.statusTextView)
        val ageTextView: TextView = itemView.findViewById(R.id.ageTextView)
        val acceptButton: Button = itemView.findViewById(R.id.acceptButton)
        val declineButton: Button = itemView.findViewById(R.id.declineButton)
    }
}