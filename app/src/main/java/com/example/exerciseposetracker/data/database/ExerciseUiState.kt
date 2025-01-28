//ExerciseUiState.kt
package com.example.exerciseposetracker.data.database

import com.example.exerciseposetracker.R



data class ExerciseUiState (
    val pushUpRep: Int = 15,
    val sitUpRep: Int = 0,
    val jogTime: Int = 0,
    val pushUpScore: Int = 15,
    val sitUpScore: Int=0,
    val jogScore: Int = 0,
    val totalScore: Int = 0,
    val gender: Int = 0, //0 male, 1 female
    val age: Int = 0,
    val nsfOrNsmen: Int = 0, //0 nsf, 1 nsmen

)