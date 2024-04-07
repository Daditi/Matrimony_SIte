package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserStateProfile(
    val firstName: String = "",
    val lastName: String = "",
    val city: String = "",
    val country: String = "",
    @PrimaryKey(autoGenerate = false)
    val email: String = "",
    val age: Int?,
    val picture: String = "",
    val status: Boolean
)