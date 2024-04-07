package com.example.room

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM USER")
    fun getAllUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<User>)

    @Query("DELETE FROM USER")
    suspend fun removeAllUsers()

    @Query("UPDATE User SET status = :status WHERE email = :email")
    suspend fun updateStatus(email: String, status: Boolean?)

}