package com.example.magicyellowsquare.di

import com.example.magicyellowsquare.data.data_source.local.dao.MagicDataDao
import com.example.magicyellowsquare.data.data_source.mapper.MagicDataMapper
import com.example.magicyellowsquare.data.data_source.repository.MagicYellowDataRepositoryImpl
import com.example.magicyellowsquare.domain.repository.MagicYellowDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMagicYellowDataRepository(magicDataDao: MagicDataDao, magicDataMapper: MagicDataMapper): MagicYellowDataRepository =
        MagicYellowDataRepositoryImpl(magicDataDao, magicDataMapper)

}