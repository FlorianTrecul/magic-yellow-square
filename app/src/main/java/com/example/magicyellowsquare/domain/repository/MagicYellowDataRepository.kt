package com.example.magicyellowsquare.domain.repository

import com.example.magicyellowsquare.domain.model.MagicData
import com.example.magicyellowsquare.util.Resource
import kotlinx.coroutines.flow.Flow

interface MagicYellowDataRepository {

    fun getAllMagicData(): Flow<Resource<List<MagicData>>>

    fun getLastMagicData(): Flow<MagicData>

    suspend fun insertMagicData(magicData: MagicData)
}