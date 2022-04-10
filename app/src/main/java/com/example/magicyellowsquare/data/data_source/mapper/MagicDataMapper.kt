package com.example.magicyellowsquare.data.data_source.mapper

import com.example.magicyellowsquare.data.data_source.entity.MagicDataEntity
import com.example.magicyellowsquare.domain.model.MagicData

class MagicDataMapper: Mapper<MagicDataEntity, MagicData> {

    override fun mapFromEntity(type: MagicDataEntity): MagicData {
        return MagicData(
            id = type.id,
            positionX = type.positionX,
            positionY = type.positionY,
            date = type.date
        )
    }

    override fun mapToEntity(type: MagicData): MagicDataEntity {
        return MagicDataEntity(
            id = type.id,
            positionX = type.positionX,
            positionY = type.positionY,
            date = type.date
        )
    }


}