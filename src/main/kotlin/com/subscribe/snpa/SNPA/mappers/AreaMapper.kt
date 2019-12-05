package com.subscribe.snpa.SNPA.mappers

import com.subscribe.snpa.SNPA.entities.Area
import com.subscribe.snpa.SNPA.models.AreaDTO


class AreaMapper : Mapper<AreaDTO, Area>() {

    override fun fromTo(from: AreaDTO): Area {
        return Area(id = from.areaId, name = from.areaName)
    }
}

class AreaMapperDTO : Mapper<Area, AreaDTO>() {

    override fun fromTo(from: Area): AreaDTO {
        return AreaDTO(areaId = from.id, areaName = from.name)
    }
}