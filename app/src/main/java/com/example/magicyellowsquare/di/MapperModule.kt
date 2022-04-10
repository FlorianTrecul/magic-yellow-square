package com.example.magicyellowsquare.di

import com.example.magicyellowsquare.data.data_source.mapper.MagicDataMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Singleton
    @Provides
    fun provideMagicDataMapper(): MagicDataMapper = MagicDataMapper()

}