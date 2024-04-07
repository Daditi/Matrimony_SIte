package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.UserRepository
import com.example.myapplication.model.UserStateProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConnectionViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    fun observeAcceptedUserData(): LiveData<List<UserStateProfile>> {
        return userRepository.getAllUserStateProfile()
    }

    fun removedUser(email: String) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.deleteUserStatus(email)
    }

}