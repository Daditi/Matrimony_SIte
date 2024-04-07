package com.example.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.model.UserStateProfile

@Dao
interface UserStateProfileDao {
    @Query("SELECT * FROM UserStateProfile")
    fun getAllUsers(): LiveData<List<UserStateProfile>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userStateProfile: UserStateProfile)

    @Query("DELETE FROM UserStateProfile WHERE email = :email")
    suspend fun deleteUser(email: String)
}