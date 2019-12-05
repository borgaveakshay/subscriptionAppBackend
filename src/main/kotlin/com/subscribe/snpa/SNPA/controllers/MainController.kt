package com.subscribe.snpa.SNPA.controllers

import com.subscribe.snpa.SNPA.models.*
import com.subscribe.snpa.SNPA.services.DBService
import com.subscribe.snpa.SNPA.services.DatabaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class MainController {


    @Autowired
    private lateinit var mDatabaseService: DBService


    @RequestMapping(path = ["/add/customer"], method = [RequestMethod.POST])
    @ResponseBody
    fun addCustomer(@RequestBody customerDTO: CustomerDTO): ResponseDTO<CustomerDTO> = mDatabaseService.addCustomer(customerDTO)

    @RequestMapping(path = ["/add/vendor"], method = [RequestMethod.POST])
    @ResponseBody
    fun addVendor(@RequestBody vendorDTO: VendorDTO): ResponseDTO<VendorDTO> = mDatabaseService.addVendor(vendorDTO)

    @RequestMapping(path = ["/auth/customer"], method = [RequestMethod.POST])
    @ResponseBody
    fun authCustomer(@RequestBody authDTO: AuthDTO): ResponseDTO<CustomerDTO> = mDatabaseService.authenticateCustomer(authDTO.email)

    @RequestMapping(path = ["/auth/vendor"], method = [RequestMethod.POST])
    @ResponseBody
    fun authVendor(@RequestBody authDTO: AuthDTO): ResponseDTO<VendorDTO> = mDatabaseService.authenticateVendor(authDTO.email)

    @RequestMapping(path = ["/area/list"], method = [RequestMethod.GET])
    @ResponseBody
    fun getAllAreas(): ResponseListDTO<AreaDTO> = mDatabaseService.getAllAreas()

    @RequestMapping(path = ["/newspapers"], method = [RequestMethod.POST])
    @ResponseBody
    fun getNewsPapers(@RequestBody areaDTO: AreaDTO): ResponseListDTO<NewsPaperDTO> = mDatabaseService.getNewsPapers(areaDTO)

    @RequestMapping(path = ["/newspaper/list"], method = [RequestMethod.GET])
    @ResponseBody
    fun getNewsPapersList(): ResponseListDTO<NewsPaperDTO> = mDatabaseService.getNewsPaperList()

    @RequestMapping(path = ["/subscribe"], method = [RequestMethod.POST])
    @ResponseBody
    fun subscribe(@RequestBody subscribeDTO: SubscribeDTO): ResponseDTO<SubscribeDTO> = mDatabaseService.subscribe(subscribeDTO)

    @RequestMapping(path = ["/unSubscribe/{subscriptionId}"], method = [RequestMethod.DELETE])
    @ResponseBody
    fun unSubscribe(@PathVariable("subscriptionId") subscriptionId: Int): ResponseDTO<Any> = mDatabaseService.unSubscribe(subscriptionId)

    @RequestMapping(path = ["/vendors"], method = [RequestMethod.POST])
    @ResponseBody
    fun getVendors(@RequestBody areaDTO: AreaDTO): ResponseListDTO<VendorDTO> = mDatabaseService.getVendors(areaDTO)

    @RequestMapping(path = ["/subscribers"], method = [RequestMethod.POST])
    @ResponseBody
    fun getSubscribers(@RequestBody vendorDTO: VendorDTO): ResponseListDTO<SubscribeDTO> = mDatabaseService.getSubscribers(vendorDTO)

    @RequestMapping(path = ["/subscriptions/{customerId}"], method = [RequestMethod.POST])
    @ResponseBody
    fun getSubscriptions(@PathVariable("customerId") customerId: Int): ResponseListDTO<SubscribeDTO> = mDatabaseService.getSubscriptions(customerId)


}