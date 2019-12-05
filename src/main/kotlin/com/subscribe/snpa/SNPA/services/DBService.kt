package com.subscribe.snpa.SNPA.services

import com.subscribe.snpa.SNPA.models.*


interface DBService {

    fun addCustomer(customerDTO: CustomerDTO): ResponseDTO<CustomerDTO>

    fun addVendor(vendorDTO: VendorDTO): ResponseDTO<VendorDTO>

    fun authenticateCustomer(email: String): ResponseDTO<CustomerDTO>

    fun authenticateVendor(email: String): ResponseDTO<VendorDTO>

    fun getAllAreas(): ResponseListDTO<AreaDTO>

    fun getNewsPapers(areaDTO: AreaDTO): ResponseListDTO<NewsPaperDTO>

    fun subscribe(subscribeDTO: SubscribeDTO): ResponseDTO<SubscribeDTO>

    fun getVendors(areaDTO: AreaDTO): ResponseListDTO<VendorDTO>

    fun getSubscribers(vendorDTO: VendorDTO): ResponseListDTO<SubscribeDTO>

    fun unSubscribe(id: Int): ResponseDTO<Any>

    fun getSubscriptions(customerId: Int): ResponseListDTO<SubscribeDTO>

    fun getNewsPaperList(): ResponseListDTO<NewsPaperDTO>
}