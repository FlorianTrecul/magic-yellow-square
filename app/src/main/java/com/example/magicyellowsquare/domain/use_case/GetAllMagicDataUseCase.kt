package com.example.magicyellowsquare.domain.use_case

import com.example.magicyellowsquare.domain.model.MagicData
import com.example.magicyellowsquare.domain.repository.MagicYellowDataRepository
import com.example.magicyellowsquare.util.Resource
import kotlinx.coroutines.flow.Flow

class GetAllMagicDataUseCase(
    private val magicYellowDataRepository: MagicYellowDataRepository
) {

    operator fun invoke(): Flow<Resource<List<MagicData>>> {
        return magicYellowDataRepository.getAllMagicData()
    }
}