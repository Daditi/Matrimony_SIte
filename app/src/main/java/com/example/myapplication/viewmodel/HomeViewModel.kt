package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.UserRepository
import com.example.myapplication.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {
    private val _screenState = MutableStateFlow<HomeScreenState>(HomeScreenState.Loading)
    val screenState: LiveData<HomeScreenState> = _screenState.asLiveData()

    init {
        getProductList()
    }

    private fun getProductList() = viewModelScope.launch(Dispatchers.IO) {
        userRepository.refreshData()
        _screenState.value = HomeScreenState.Completed
    }

    fun observeUserData(): LiveData<List<User>> {
        return userRepository.getAllUsers()
    }

    fun updateUserStatus(user: User, status: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        user.status = status
        userRepository.updateStatus(user)
    }
}