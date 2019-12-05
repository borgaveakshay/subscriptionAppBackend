package com.subscribe.snpa.SNPA.mappers

import com.subscribe.snpa.SNPA.entities.NewsPapers
import com.subscribe.snpa.SNPA.entities.Vendor
import com.subscribe.snpa.SNPA.models.NewsPaperDTO
import com.subscribe.snpa.SNPA.models.VendorDTO
import com.subscribe.snpa.SNPA.utils.MapperUtils

class VendorMapper : Mapper<VendorDTO, Vendor>() {


    override fun fromTo(from: VendorDTO): Vendor = Vendor(id = from.vendorId,
            name = from.name,
            area = MapperUtils.getAreaMapper().fromTo(from.areaDTO),
            email = from.email,
            newsPapers = getVendorNewsPaperList(from.newsPapers))


    private fun getVendorNewsPaperList(newsPaperDTOList: Set<NewsPaperDTO>): Set<NewsPapers> {

        val newsPaperSet: MutableSet<NewsPapers> = mutableSetOf()
        newsPaperDTOList.map {
            newsPaperSet.add(MapperUtils.getNewsMapper().fromTo(it))
        }

        return newsPaperSet.toSet()
    }
}


class VendorMapperDTO : Mapper<Vendor, VendorDTO>() {

    override fun fromTo(from: Vendor): VendorDTO = VendorDTO(vendorId = from.id,
            name = from.name,
            email = from.email,
            areaDTO = MapperUtils.getAreaMapperDTO().fromTo(from.area),
            newsPapers = getVendorNewsPaperList(from.newsPapers))


    private fun getVendorNewsPaperList(newsPaperDTOList: Set<NewsPapers>): Set<NewsPaperDTO> {

        val newsPaperSet: MutableSet<NewsPaperDTO> = mutableSetOf()
        newsPaperDTOList.map {
            newsPaperSet.add(MapperUtils.getNewsDTOMapper().fromTo(it))
        }

        return newsPaperSet.toSet()
    }
}