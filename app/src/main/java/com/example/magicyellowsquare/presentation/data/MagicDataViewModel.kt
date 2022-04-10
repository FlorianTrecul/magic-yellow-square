package com.example.magicyellowsquare.presentation.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.magicyellowsquare.domain.use_case.MagicDataUseCases
import com.example.magicyellowsquare.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MagicDataViewModel @Inject constructor(
    private val magicDataUseCases: MagicDataUseCases
): ViewModel() {

    private val _magicalDataFlowEvent = MutableSharedFlow<MagicDataUiEvent>()
    val magicalDataFlowEvent = _magicalDataFlowEvent.asSharedFlow()

    private val _state = MutableStateFlow<MagicDataUiState>(MagicDataUiState.Empty)
    val state = _state.asStateFlow()

    private fun getAllMagicData() = viewModelScope.launch(Dispatchers.IO) {
        magicDataUseCases.getAllMagicData()
            .onEach { magicData ->
                when (magicData) {
                    is Resource.Empty -> _state.value = MagicDataUiState.Empty
                    is Resource.Loading -> _state.value = MagicDataUiState.Loading
                    is Resource.Success -> {
                        _state.value = MagicDataUiState.Success(magicData.data)
                        Timber.d("getAllMagicData ${magicData.data}")
                    }
                    is Resource.Error -> {
                        _state.value = MagicDataUiState.Error
                        onShowDialogMessage(magicData.title, magicData.message)
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    fun onEvent(event: MagicDataEvent) {
        when(event) {
            MagicDataEvent.GetAllMagicData -> getAllMagicData()
        }
    }

    private fun onShowDialogMessage(title: Int?, message: Int?) = viewModelScope.launch {
        _magicalDataFlowEvent.emit(MagicDataUiEvent.ShowDialogMessage(title, message))
    }

    sealed class MagicDataUiEvent {
        data class ShowDialogMessage(val title: Int?, val message: Int?) : MagicDataUiEvent()
    }
}