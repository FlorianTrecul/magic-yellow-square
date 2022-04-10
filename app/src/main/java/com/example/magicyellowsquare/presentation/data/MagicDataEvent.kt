package com.example.magicyellowsquare.presentation.data

sealed class MagicDataEvent {
    object GetAllMagicData : MagicDataEvent()
}