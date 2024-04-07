package com.example.myapplication.viewmodel

sealed class HomeScreenState {
    object Loading : HomeScreenState()
    object Completed : HomeScreenState()
}
