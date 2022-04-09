package com.example.magicyellowsquare.presentation.surface

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MagicSurfaceViewModel @Inject constructor(): ViewModel() {

    private val _magicalSurfaceFlowEvent = MutableSharedFlow<MagicSurfaceUiEvent>()
    val magicalSurfaceFlowEvent = _magicalSurfaceFlowEvent.asSharedFlow()

    fun onNavigateToMagicDataScreen() = viewModelScope.launch {
        _magicalSurfaceFlowEvent.emit(MagicSurfaceUiEvent.NavigateToMagicDataScreen)
    }

    sealed class MagicSurfaceUiEvent {
        object NavigateToMagicDataScreen : MagicSurfaceUiEvent()
    }
}