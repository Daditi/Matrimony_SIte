package com.example.myapplication.domain

import androidx.lifecycle.LiveData
import com.example.myapplication.model.User
import com.example.myapplication.model.UserStateProfile

interface UserRepository {
    suspend fun refreshData()
    fun getAllUsers(): LiveData<List<User>>
    fun getAllUserStateProfile(): LiveData<List<UserStateProfile>>
    suspend fun updateStatus(user: User)
    suspend fun deleteUserStatus(email: String)
}