package com.example.magicyellowsquare.data.data_source.repository

import com.example.magicyellowsquare.R
import com.example.magicyellowsquare.data.data_source.local.dao.MagicDataDao
import com.example.magicyellowsquare.data.data_source.mapper.MagicDataMapper
import com.example.magicyellowsquare.domain.model.MagicData
import com.example.magicyellowsquare.domain.repository.MagicYellowDataRepository
import com.example.magicyellowsquare.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MagicYellowDataRepositoryImpl @Inject constructor(
    private val magicDataDao: MagicDataDao,
    private val magicDataMapper: MagicDataMapper
) : MagicYellowDataRepository {

    override fun getAllMagicData(): Flow<Resource<List<MagicData>>> = flow {
        emit(Resource.Loading)
        try {
            val magicDatasEntity = magicDataDao.getAllMagicData()
            emit(
                Resource.Success(
                    magicDatasEntity.map { magicDataEntity ->
                        magicDataMapper.mapFromEntity(magicDataEntity)
                    }
                )
            )
        } catch (e: Exception) {
            emit(Resource.Error(
                R.string.error_message_title_unknown,
                R.string.error_message_info_unknown
            ))
        }
    }

    override fun getLastMagicData(): Flow<MagicData> = flow {
        val response = magicDataDao.getLastMagicData()
        if (response != null) {
            emit(magicDataMapper.mapFromEntity(response))
        } else {
            emit(MagicData(null, 0.0, 0.0, System.currentTimeMillis()))
        }

    }

    override suspend fun insertMagicData(magicData: MagicData) {
        magicDataDao.insertMagicData(magicDataMapper.mapToEntity(magicData))
    }

}