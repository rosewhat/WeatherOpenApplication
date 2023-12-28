package com.example.weatheropenapplication.screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()

    /*Scaffold(
        topBar = {
            AppBar(navController = navController)
        },
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {*/
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                HomeScreen(navController = navController)
            }
           /* composable("Notifications") {
                NotificationsScreen(navController = navController)
            }
            composable("Settings") {
                SettingsScreen(navController = navController)
            }
            composable("Like") {
                LikedRecordsScreen(navController = navController)
            }*/
            composable("weather/{location_key}/{name}/{country}", arguments = listOf(
                navArgument("location_key") {
                    type = NavType.StringType
                },
                navArgument("name") {
                    type = NavType.StringType
                },
                navArgument("country") {
                    type = NavType.StringType
                }
            )) {
                WeatherScreen(
                    navController = navController,
                    locationKey = it.arguments?.getString("location_key") ?: "",
                    locationName = it.arguments?.getString("name") ?: "",
                    country = it.arguments?.getString("country") ?: ""
                )
            }
        }
    }
/*
}*/
