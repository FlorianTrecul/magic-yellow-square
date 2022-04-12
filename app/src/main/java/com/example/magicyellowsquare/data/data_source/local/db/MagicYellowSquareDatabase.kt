package com.example.magicyellowsquare.data.data_source.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.magicyellowsquare.data.data_source.entity.MagicDataEntity
import com.example.magicyellowsquare.data.data_source.local.dao.MagicDataDao
import com.example.magicyellowsquare.util.Constants.DATABASE_NAME

@Database(entities = [MagicDataEntity::class], version = 1)
abstract class MagicYellowSquareDatabase: RoomDatabase() {

    abstract fun magicDataDao(): MagicDataDao

    companion object {

        @Volatile
        private var INSTANCE: MagicYellowSquareDatabase? = null

        fun getDatabaseInstance(context: Context): MagicYellowSquareDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MagicYellowSquareDatabase::class.java,
                    DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}