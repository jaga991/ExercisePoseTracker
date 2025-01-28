//MainActivity.kt
package com.example.exerciseposetracker

import com.example.exerciseposetracker.ui.theme.ExercisePoseTrackerTheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.exerciseposetracker.ui.screens.MainScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExercisePoseTrackerTheme {
                val navController = rememberNavController()
                AppNavHost(navController=navController)
            }
        }
    }
}