package com.example.myapplication.compose

sealed class NavigationItem(var route: String) {
    object Home : NavigationItem("Home")
    object History : NavigationItem("History")
    object Profile : NavigationItem("Profile")
    object Search : NavigationItem("Search")
    object Account : NavigationItem("Account")
}
