package com.arturotorralbo.aplicacionvideojuegologros.home.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arturotorralbo.aplicacionvideojuegologros.home.data.model.UiState
import com.arturotorralbo.aplicacionvideojuegologros.home.domain.AchivementsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val achivementsUseCase: AchivementsUseCase
) : ViewModel() {
    private val _uiState = mutableStateOf<UiState>(UiState.Loading)
    val uiState: State<UiState> = _uiState
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    private val _id = MutableLiveData<Int>()
    val id: LiveData<Int> = _id
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name
    private val _difficulty = MutableLiveData<String>()
    val difficulty: LiveData<String> = _difficulty
    private val _description = MutableLiveData<String>()
    val description: LiveData<String> = _description
    private val _image = MutableLiveData<String>()
    val image: LiveData<String> = _image





    fun achivements() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = achivementsUseCase(_id.value!!, _name.value!!, _description.value!!, _difficulty.value!!, _image.value!!)


            _isLoading.value = false
        }
    }



}