package com.subscribe.snpa.SNPA.repositories

import com.subscribe.snpa.SNPA.entities.Area
import com.subscribe.snpa.SNPA.entities.Vendor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface VendorRepository : CrudRepository<Vendor, Int> {

    fun findVendorByArea(area: Area): Vendor

    fun findAllVendorsByArea(area: Area): List<Vendor>

    fun findVendorByEmail(email: String): Vendor?

}