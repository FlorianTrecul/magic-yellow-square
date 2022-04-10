package com.example.magicyellowsquare.domain.repository

import com.example.magicyellowsquare.domain.model.MagicData

interface MagicYellowDataRepository {

    suspend fun insertMagicData(magicData: MagicData)
}