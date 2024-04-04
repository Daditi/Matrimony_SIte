package com.example.myapplication.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.BottomBarBackground
import com.example.myapplication.ui.theme.BottomBarSelected
import com.example.myapplication.ui.theme.BottomBarUnselected
import com.example.myapplication.ui.theme.ScreenBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopBarComposable()
        },
        bottomBar = {
            BottomAppBar(containerColor = BottomBarBackground) {
                CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
                    BottomNavigationBar(navController = navController)
                }
            }
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(ScreenBackground)
                .fillMaxSize()
        ) {
            Navigation(navController = navController)
        }
    }
}

@Composable
internal fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            ProductListScreen()
        }
        composable(NavigationItem.History.route) {
            ProductGridScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
        composable(NavigationItem.Search.route) {
            SearchScreen()
        }
        composable(NavigationItem.Account.route) {
            AccountScreen()
        }
    }
}

@Composable
internal fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.History,
        NavigationItem.Profile,
        NavigationItem.Search,
        NavigationItem.Account,
    )
    var selectedItem by remember { mutableIntStateOf(0) }
    var currentRoute by remember { mutableStateOf(NavigationItem.Home.route) }

    items.forEachIndexed { index, navigationItem ->
        if (navigationItem.route == currentRoute) {
            selectedItem = index
        }
    }
    NavigationBar(containerColor = BottomBarBackground) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(
                                if (selectedItem == index) BottomBarSelected else BottomBarUnselected,
                                CircleShape
                            )
                    )
                },
                selected = selectedItem == index,
                colors = androidx.compose.material3.NavigationBarItemDefaults
                    .colors(
                        indicatorColor = BottomBarBackground
                    ),
                onClick = {
                    selectedItem = index
                    currentRoute = item.route
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}