package com.example.magicyellowsquare.data.data_source.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MagicDataEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val positionX: Double,
    val positionY: Double,
    val date: Long
)