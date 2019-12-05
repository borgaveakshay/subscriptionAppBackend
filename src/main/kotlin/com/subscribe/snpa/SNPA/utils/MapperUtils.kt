package com.subscribe.snpa.SNPA.utils

import com.subscribe.snpa.SNPA.mappers.*

object MapperUtils {


    fun getNewsMapper(): NewsMapper = NewsMapper()

    fun getNewsDTOMapper(): NewsDTOMapper = NewsDTOMapper()

    fun getAreaMapper(): AreaMapper = AreaMapper()

    fun getAreaMapperDTO(): AreaMapperDTO = AreaMapperDTO()

    fun getCustomerMapper(): CustomerMapper = CustomerMapper()

    fun getCustomerMapperDTO(): CustomerMapperDTO = CustomerMapperDTO()

    fun getVendorMapper(): VendorMapper = VendorMapper()

    fun getVendorMapperDTO(): VendorMapperDTO = VendorMapperDTO()

    fun getSubscriptionMapper(): SubscriptionMapper = SubscriptionMapper()

    fun getSubscriptionMapperDTO(): SubscriptionMapperDTO = SubscriptionMapperDTO()
}