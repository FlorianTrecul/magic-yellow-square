package com.example.magicyellowsquare.presentation.data

import com.example.magicyellowsquare.domain.model.MagicData

sealed class MagicDataUiState {
    object Empty: MagicDataUiState()
    object Loading: MagicDataUiState()
    data class Success(val magicData: List<MagicData>) : MagicDataUiState()
    object Error: MagicDataUiState()
}
