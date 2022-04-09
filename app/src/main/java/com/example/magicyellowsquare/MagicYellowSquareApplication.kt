package com.example.magicyellowsquare

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MagicYellowSquareApplication : Application() {

    companion object {

        private lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        plantTimber()

        appContext = this
    }

    private fun plantTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}