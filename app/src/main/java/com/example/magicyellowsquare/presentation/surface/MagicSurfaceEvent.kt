package com.example.magicyellowsquare.presentation.surface

sealed class MagicSurfaceEvent {
    data class SaveMagicData(val positionX: Double, val positionY: Double) : MagicSurfaceEvent()
}