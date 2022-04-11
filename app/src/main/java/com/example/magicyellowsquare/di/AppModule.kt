package com.example.magicyellowsquare.di

import com.example.magicyellowsquare.domain.repository.MagicYellowDataRepository
import com.example.magicyellowsquare.domain.use_case.AddMagicDataUseCase
import com.example.magicyellowsquare.domain.use_case.GetAllMagicDataUseCase
import com.example.magicyellowsquare.domain.use_case.GetLastMagicDataUseCase
import com.example.magicyellowsquare.domain.use_case.MagicDataUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMagicDataUseCases(
        magicYellowDataRepository: MagicYellowDataRepository
    ): MagicDataUseCases {
        return MagicDataUseCases(
            addMagicData = AddMagicDataUseCase(magicYellowDataRepository),
            getAllMagicData = GetAllMagicDataUseCase(magicYellowDataRepository),
            getLastMagicData = GetLastMagicDataUseCase(magicYellowDataRepository)
        )
    }

}