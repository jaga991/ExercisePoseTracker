package com.example.exerciseposetracker.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.exerciseposetracker.R
import androidx.compose.ui.Modifier


@Composable
fun ExerciseList(
    pushUpRep: Int,
    sitUpRep: Int,
    jogTime: Int,
    pushUpScore: Int,
    sitUpScore: Int,
    jogScore: Int,
    totalScore: Int,
    gender: Int,
    age: Int,
    nsfOrNsmen: Int,
    onRepChange: (String, Int) -> Unit
) {

    val exercises = listOf(
        listOf("Push-Up", R.drawable.push_up, pushUpRep,pushUpScore), // [Name, IconRes, Reps]
        listOf("Sit-Up", R.drawable.sit_up, sitUpRep, sitUpScore ),  // [Name, IconRes, Reps]
        listOf("2.4km-Run", R.drawable.run, jogTime, jogScore)   // [Name, IconRes, Time]
    )


    Column {
        exercises.forEach { exercise ->
            val name = exercise[0] as String // Cast to String
            val iconRes = exercise[1] as Int // Cast to Int
            val rep = exercise[2] as Int // Cast to Int
            val score = exercise[3] as Int // Cast to Int

            ExerciseCard(
                name,
                iconRes,
                rep,
                score,
                onRepChange
            )
        }



    }

}

