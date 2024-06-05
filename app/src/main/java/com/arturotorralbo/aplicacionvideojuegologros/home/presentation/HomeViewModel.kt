package com.arturotorralbo.aplicacionvideojuegologros.home.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.arturotorralbo.aplicacionvideojuegologros.home.data.model.UiState

class HomeViewModel : ViewModel() {
    private val _uiState = mutableStateOf<UiState>(UiState.Loading)
    val uiState: State<UiState> = _uiState



}