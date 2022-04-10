package com.example.magicyellowsquare.data.data_source.repository

import com.example.magicyellowsquare.data.data_source.local.dao.MagicDataDao
import com.example.magicyellowsquare.data.data_source.mapper.MagicDataMapper
import com.example.magicyellowsquare.domain.model.MagicData
import com.example.magicyellowsquare.domain.repository.MagicYellowDataRepository
import javax.inject.Inject

class MagicYellowDataRepositoryImpl @Inject constructor(
    private val magicDataDao: MagicDataDao,
    private val magicDataMapper: MagicDataMapper
) : MagicYellowDataRepository {

    override suspend fun insertMagicData(magicData: MagicData) {
        magicDataDao.insertMagicData(magicDataMapper.mapToEntity(magicData))
    }

}