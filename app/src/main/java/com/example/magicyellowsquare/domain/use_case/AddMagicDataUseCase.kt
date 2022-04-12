package com.example.magicyellowsquare.domain.use_case

import com.example.magicyellowsquare.domain.model.MagicData
import com.example.magicyellowsquare.domain.repository.MagicYellowDataRepository

class AddMagicDataUseCase(
    private val magicYellowDataRepository: MagicYellowDataRepository
) {

    suspend operator fun invoke(magicData: MagicData) {
        magicYellowDataRepository.insertMagicData(magicData)
    }
}