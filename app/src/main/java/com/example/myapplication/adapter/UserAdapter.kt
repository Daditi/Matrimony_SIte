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
import com.example.myapplication.model.User
import com.squareup.picasso.Picasso

class UserAdapter(
    private val userList: MutableList<User>,
    private val listener: OnUserActionListener
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    fun updateUsers(users: List<User>) {
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
        holder.firstNameTextView.text = user.firstName
        holder.lastNameTextView.text = user.lastName
        user.age?.let {
            holder.ageTextView.isVisible = true
            holder.ageTextView.text = "Age: $it"
        }
        holder.locationTextView.text = "From ${user.city}, ${user.country}"
        when (user.status) {
            true -> {
                holder.acceptButton.isEnabled = false
                holder.declineButton.isEnabled = true
                holder.acceptButton.setBackgroundResource(R.drawable.selected_button_background)
                holder.declineButton.setBackgroundResource(R.drawable.unselected_button_background)
            }

            false -> {
                holder.acceptButton.isEnabled = true
                holder.declineButton.isEnabled = false
                holder.declineButton.setBackgroundResource(R.drawable.selected_button_background)
                holder.acceptButton.setBackgroundResource(R.drawable.unselected_button_background)
            }

            else -> {
                holder.acceptButton.isEnabled = true
                holder.declineButton.isEnabled = true
            }
        }

        holder.acceptButton.setOnClickListener {
            listener.onAccept(user)
        }

        holder.declineButton.setOnClickListener {
            listener.onDecline(user)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    interface OnUserActionListener {
        fun onAccept(user: User)
        fun onDecline(user: User)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.profileImage)
        val firstNameTextView: TextView = itemView.findViewById(R.id.firstNameTextView)
        val lastNameTextView: TextView = itemView.findViewById(R.id.lastNameTextView)
        val ageTextView: TextView = itemView.findViewById(R.id.ageTextView)
        val locationTextView: TextView = itemView.findViewById(R.id.locationTextView)
        val acceptButton: Button = itemView.findViewById(R.id.acceptButton)
        val declineButton: Button = itemView.findViewById(R.id.declineButton)
    }
}