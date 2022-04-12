package com.example.magicyellowsquare.presentation.surface

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.magicyellowsquare.domain.model.MagicData
import com.example.magicyellowsquare.domain.use_case.MagicDataUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MagicSurfaceViewModel @Inject constructor(
    private val magicDataUseCases: MagicDataUseCases
): ViewModel() {

    private val _magicalSurfaceFlowEvent = MutableSharedFlow<MagicSurfaceUiEvent>()
    val magicalSurfaceFlowEvent = _magicalSurfaceFlowEvent.asSharedFlow()

    val getLastMagicData get() = magicDataUseCases.getLastMagicData()

    private fun saveMagicData(magicData: MagicData) = viewModelScope.launch(Dispatchers.IO) {
        magicDataUseCases.addMagicData(magicData)
    }

    fun onEvent(event: MagicSurfaceEvent) {
        when(event) {
            is MagicSurfaceEvent.SaveMagicData -> saveMagicData(MagicData(null, event.positionX, event.positionY, System.currentTimeMillis()))
        }
    }

    fun onNavigateToMagicDataScreen() = viewModelScope.launch {
        _magicalSurfaceFlowEvent.emit(MagicSurfaceUiEvent.NavigateToMagicDataScreen)
    }

    fun onShowToastMessage(message: String) = viewModelScope.launch {
        _magicalSurfaceFlowEvent.emit(MagicSurfaceUiEvent.ShowToastMessage(message))
    }

    sealed class MagicSurfaceUiEvent {
        object NavigateToMagicDataScreen : MagicSurfaceUiEvent()
        data class ShowToastMessage(val message: String) : MagicSurfaceUiEvent()
    }
}