//ExerciseViewModel.kt
package com.example.exerciseposetracker.domain.models

import androidx.lifecycle.ViewModel
import com.example.exerciseposetracker.data.database.ExerciseUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ExerciseViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(ExerciseUiState())
    val uiState: StateFlow<ExerciseUiState> = _uiState.asStateFlow()

    fun updateScore(exerciseName: String, repInput: Int) {
        when(exerciseName){
            "Push-Up" -> _uiState.value =  _uiState.value.copy(pushUpScore = repInput)
            "Sit-Up" ->_uiState.value = _uiState.value.copy(sitUpScore = repInput)
            "2.4km-Run" ->_uiState.value = _uiState.value.copy(jogScore = repInput)
        }

        _uiState.value = _uiState.value.copy(totalScore = _uiState.value.sitUpScore + _uiState.value.pushUpScore + _uiState.value.jogScore)
    }


    // Function to update Push-Up Reps
    fun updatePushUpRep(newRep: Int) {
        _uiState.value = _uiState.value.copy(pushUpRep = newRep)
        updateScore("Push-Up", newRep)
    }

    // Function to update Sit-Up Reps
    fun updateSitUpRep(newRep: Int) {
        _uiState.value = _uiState.value.copy(sitUpRep = newRep)
        updateScore("Sit-Up", newRep)
    }

    // Function to update Jogging Time
    fun updateJogTime(newTime: Int) {
        _uiState.value = _uiState.value.copy(jogTime = newTime)
        updateScore("2.4km-Run", newTime)
    }

    // Function to update Gender
    fun updateGender(newGender: Int) {
        _uiState.value = _uiState.value.copy(gender = newGender)
    }

    // Function to update Age
    fun updateAge(newAge: Int) {
        _uiState.value = _uiState.value.copy(age = newAge)
    }

    // Function to update NSF/NSmen Status
    fun updateNsfOrNsmen(newStatus: Int) {
        _uiState.value = _uiState.value.copy(nsfOrNsmen = newStatus)
    }

    fun updateExerciseUi(dataName:String, data: Int) {
        when(dataName){
            "Push-Up" -> updatePushUpRep(data)
            "Sit-Up" -> updateSitUpRep(data)
            "2.4km-Run" -> updateJogTime(data)
            "Gender" -> updateGender(data)
            "Age" -> updateGender(data)
            "NsfOrNsmen" -> updateNsfOrNsmen(data)
        }
    }

}