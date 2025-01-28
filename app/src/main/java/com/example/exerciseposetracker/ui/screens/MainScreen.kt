package com.example.exerciseposetracker.ui.screens
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.Alignment


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exerciseposetracker.domain.models.ExerciseViewModel

import com.example.exerciseposetracker.ui.components.ExerciseList



@Preview
@Composable
fun MainScreen(exerciseViewModel: ExerciseViewModel = viewModel(), navigateToSummary: () -> Unit = {}) {
    val  exerciseUiState by exerciseViewModel.uiState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ExerciseList(
            pushUpRep = exerciseUiState.pushUpRep,
            sitUpRep = exerciseUiState.sitUpRep,
            jogTime = exerciseUiState.jogTime,
            pushUpScore = exerciseUiState.pushUpScore,
            sitUpScore = exerciseUiState.sitUpScore,
            jogScore = exerciseUiState.jogScore,
            totalScore = exerciseUiState.totalScore,
            gender = exerciseUiState.gender,
            age = exerciseUiState.age,
            nsfOrNsmen = exerciseUiState.nsfOrNsmen,

            onRepChange = { dataName, data -> exerciseViewModel.updateExerciseUi(dataName, data) }

        )


        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Male Option
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = exerciseUiState.gender == 0, // 0 = Male
                    onClick = { exerciseViewModel.updateGender(0) } // Update to Male
                )
                Text(text = "Male")
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Female Option
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = exerciseUiState.gender == 1, // 1 = Female
                    onClick = { exerciseViewModel.updateGender(1) } // Update to Female
                )
                Text(text = "Female")
            }
        }
        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Male Option
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = exerciseUiState.nsfOrNsmen == 0, // 0 = NSF
                    onClick = { exerciseViewModel.updateNsfOrNsmen(0) } // Update to NSF
                )
                Text(text = "NSF")
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Female Option
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = exerciseUiState.nsfOrNsmen == 1, // 1 = NSMen
                    onClick = { exerciseViewModel.updateNsfOrNsmen(1) } // Update to NSMen
                )
                Text(text = "NSMen")
            }
        }

        // Text Input for Age
        Text(text = "Age:")
        TextField(
            value = exerciseUiState.age.toString(), // Convert Int to String for the TextField
            onValueChange = { newValue ->
                val newAge = newValue.toIntOrNull() // Convert String to Int safely
                if (newAge != null) { // Validate the age range
                    exerciseViewModel.updateAge(newAge) // Update ViewModel if valid
                }
            },
            singleLine = true,
        )
        Button (onClick = navigateToSummary) {
            Text(text = "Go to Summary")
        }

    }
}
