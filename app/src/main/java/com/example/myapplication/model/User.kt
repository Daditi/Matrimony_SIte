package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    val gender: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val city: String = "",
    val country: String = "",
    @PrimaryKey(autoGenerate = false)
    val email: String = "",
    val age: Int?,
    val dob: String = "",
    val phone: String = "",
    val cell: String = "",
    val id: String = "",
    val picture: String = "",
    var status: Boolean? = null
)
