package com.example.magicyellowsquare.di

import android.content.Context
import com.example.magicyellowsquare.data.data_source.local.dao.MagicDataDao
import com.example.magicyellowsquare.data.data_source.local.db.MagicYellowDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Singleton
    @Provides
    fun provideMagicYellowSquareDatabase(@ApplicationContext appContext: Context): MagicYellowDatabase =
        MagicYellowDatabase.getDatabaseInstance(appContext)

    @Singleton
    @Provides
    fun provideMagicDataDao(magicYellowDatabase: MagicYellowDatabase): MagicDataDao =
        magicYellowDatabase.magicDataDao()
}