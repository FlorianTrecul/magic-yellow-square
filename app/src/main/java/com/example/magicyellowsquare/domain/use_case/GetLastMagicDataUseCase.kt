package com.example.magicyellowsquare.domain.use_case

import com.example.magicyellowsquare.domain.model.MagicData
import com.example.magicyellowsquare.domain.repository.MagicYellowDataRepository
import kotlinx.coroutines.flow.Flow

class GetLastMagicDataUseCase(
    private val magicYellowDataRepository: MagicYellowDataRepository
) {

    operator fun invoke(): Flow<MagicData> {
        return magicYellowDataRepository.getLastMagicData()
    }
}