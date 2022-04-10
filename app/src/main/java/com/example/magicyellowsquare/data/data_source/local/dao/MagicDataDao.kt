package com.example.magicyellowsquare.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.magicyellowsquare.data.data_source.entity.MagicDataEntity

@Dao
interface MagicDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMagicData(magicDataEntity: MagicDataEntity)
}