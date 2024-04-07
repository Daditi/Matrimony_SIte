package com.example.myapplication.data

import androidx.lifecycle.LiveData
import com.example.myapplication.domain.UserRepository
import com.example.myapplication.mapper.mapToUserResult
import com.example.myapplication.mapper.mapToUserStateProfile
import com.example.myapplication.model.User
import com.example.myapplication.model.UserStateProfile
import com.example.myapplication.network.APIService
import com.example.room.UserDao
import com.example.room.UserStateProfileDao
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: APIService,
    private val userDao: UserDao,
    private val userStateProfileDao: UserStateProfileDao
) : UserRepository {

    override suspend fun refreshData() {
        runCatching {
            val data = apiService.getProducts(10).body()?.users.mapToUserResult()
            userDao.removeAllUsers()
            userDao.insertUsers(data)
        }
    }

    override fun getAllUsers(): LiveData<List<User>> {
        return userDao.getAllUsers()
    }

    override fun getAllUserStateProfile(): LiveData<List<UserStateProfile>> {
        return userStateProfileDao.getAllUsers()
    }

    override suspend fun updateStatus(user: User) {
        val userStateProfile = user.mapToUserStateProfile()
        userStateProfileDao.insertUser(userStateProfile)
        userDao.updateStatus(user.email, user.status)
    }

    override suspend fun deleteUserStatus(email: String) {
        userStateProfileDao.deleteUser(email)
    }
}
