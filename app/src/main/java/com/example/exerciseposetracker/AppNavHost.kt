package com.example.exerciseposetracker

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.exerciseposetracker.ui.screens.MainScreen
import com.example.exerciseposetracker.ui.screens.SummaryScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "MainScreen"
    ) {
        composable("MainScreen") {
            MainScreen(
                navigateToSummary = { navController.navigate("SummaryScreen") }
            )
        }
        composable("SummaryScreen") {
            SummaryScreen(
                navigateBack = { navController.popBackStack() }
            )
        }
    }


}