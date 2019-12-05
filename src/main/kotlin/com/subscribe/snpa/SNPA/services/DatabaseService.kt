package com.subscribe.snpa.SNPA.services

import com.subscribe.snpa.SNPA.entities.Customer
import com.subscribe.snpa.SNPA.entities.Subscriptions
import com.subscribe.snpa.SNPA.entities.Vendor
import com.subscribe.snpa.SNPA.models.*
import com.subscribe.snpa.SNPA.repositories.*
import com.subscribe.snpa.SNPA.utils.MapperUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DatabaseService : DBService {


    @Autowired
    private lateinit var mCustomerRepository: CustomerRepository

    @Autowired
    private lateinit var mAreaRepository: AreaRepository

    @Autowired
    private lateinit var mVendorRepository: VendorRepository

    @Autowired
    private lateinit var mSubscriptionRepository: SubscriptionRepository

    @Autowired
    private lateinit var mNewsPapersRepository: NewsPapersRepository


    override fun addCustomer(customerDTO: CustomerDTO): ResponseDTO<CustomerDTO> {
        val response = ResponseDTO<CustomerDTO>()
        val customerSave = MapperUtils.getCustomerMapper().fromTo(customerDTO)
        val customer = mCustomerRepository.save(customerSave)

        response.result = MapperUtils.getCustomerMapperDTO().fromTo(customer)

        return response
    }

    override fun addVendor(vendorDTO: VendorDTO): ResponseDTO<VendorDTO> {
        val response = ResponseDTO<VendorDTO>()

        val vendor = mVendorRepository.save(MapperUtils.getVendorMapper().fromTo(vendorDTO))

        response.result = MapperUtils.getVendorMapperDTO().fromTo(vendor)

        return response

    }

    override fun authenticateCustomer(email: String): ResponseDTO<CustomerDTO> {
        val customer: Customer? = mCustomerRepository.findByEmail(email = email)

        val responseDTO = ResponseDTO<CustomerDTO>()

        return when (customer) {

            null -> {
                responseDTO.statusCode = 400
                responseDTO.statusMessage = "Error while authentication"
                responseDTO
            }
            else -> {

                responseDTO.result = MapperUtils.getCustomerMapperDTO().fromTo(customer)
                responseDTO.statusMessage = "Authentication Successful"
                responseDTO
            }
        }

    }

    override fun authenticateVendor(email: String): ResponseDTO<VendorDTO> {
        val vendor: Vendor? = mVendorRepository.findVendorByEmail(email = email)

        val responseDTO = ResponseDTO<VendorDTO>()

        return when (vendor) {

            null -> {
                responseDTO.statusCode = 400
                responseDTO.statusMessage = "Error while authentication"
                responseDTO
            }
            else -> {

                responseDTO.result = MapperUtils.getVendorMapperDTO().fromTo(vendor)
                responseDTO.statusMessage = "Authentication Successful"
                responseDTO
            }
        }
    }

    override fun getAllAreas(): ResponseListDTO<AreaDTO> {

        val result = ResponseListDTO<AreaDTO>()
        val list: MutableList<AreaDTO> = mutableListOf()

        mAreaRepository.findAll().map { area ->

            area?.let {
                list.add(MapperUtils.getAreaMapperDTO().fromTo(it))
            }

        }

        if (result.result?.size == 0) {
            result.statusMessage = "No Items Found."
        }
        result.result = list

        return result
    }


    override fun getNewsPapers(areaDTO: AreaDTO): ResponseListDTO<NewsPaperDTO> {

        val response = ResponseListDTO<NewsPaperDTO>()
        val list: MutableList<NewsPaperDTO> = mutableListOf()

        try {

            val area = MapperUtils.getAreaMapper().fromTo(areaDTO)

            val vendor = mVendorRepository.findVendorByArea(area)

            vendor.newsPapers.let { set ->

                set.map {
                    list.add(MapperUtils.getNewsDTOMapper().fromTo(it))
                }

            }

        } catch (e: Exception) {

            // bypass exception
        }


        response.result = list

        if (response.result?.size == 0) {
            response.statusMessage = "No Items Found."
        }




        return response
    }


    override fun subscribe(subscribeDTO: SubscribeDTO): ResponseDTO<SubscribeDTO> {


        val response = ResponseDTO<SubscribeDTO>()

        val subscriptionsModel = MapperUtils.getSubscriptionMapper().fromTo(subscribeDTO)

        val customer = mCustomerRepository.findById(subscriptionsModel.customer.id)

        val vendor = mVendorRepository.findVendorByArea(subscriptionsModel.vendor.area)

        val newsPaper = mNewsPapersRepository.findById(subscriptionsModel.newsPapers.id)

        val subscriptions = Subscriptions(subscriptionEnd = subscribeDTO.SubscriptionEndDate,
                subscriptionStart = subscribeDTO.SubscriptionStartDate,
                vendor = vendor,
                newsPapers = newsPaper.get(),
                customer = customer.get())

        response.result = MapperUtils.getSubscriptionMapperDTO().fromTo(mSubscriptionRepository.save(subscriptions))
        return response
    }


    override fun getVendors(areaDTO: AreaDTO): ResponseListDTO<VendorDTO> {

        val area = MapperUtils.getAreaMapper().fromTo(areaDTO)
        val list = mVendorRepository.findAllVendorsByArea(area)

        val result = ResponseListDTO<VendorDTO>()
        val dtoList: MutableList<VendorDTO> = mutableListOf()

        list.map {
            dtoList.add(MapperUtils.getVendorMapperDTO().fromTo(it))
        }

        result.result = dtoList

        return result

    }

    override fun getSubscribers(vendorDTO: VendorDTO): ResponseListDTO<SubscribeDTO> {
        val response = ResponseListDTO<SubscribeDTO>()
        val subscribeDTOList: MutableList<SubscribeDTO> = mutableListOf()

        val subscriptionList = mSubscriptionRepository.findAllSubscriptionsByVendor(MapperUtils.getVendorMapper().fromTo(vendorDTO))

        subscriptionList.map {

            subscribeDTOList.add(MapperUtils.getSubscriptionMapperDTO().fromTo(it))
        }

        response.result = subscribeDTOList

        return response
    }

    override fun unSubscribe(id: Int): ResponseDTO<Any> {

        val response = ResponseDTO<Any>()

        mSubscriptionRepository.deleteById(id)

        return response
    }


    override fun getSubscriptions(customerId: Int): ResponseListDTO<SubscribeDTO> {
        val response = ResponseListDTO<SubscribeDTO>()
        val subscriptionsList: MutableList<SubscribeDTO> = mutableListOf()

        try {
            val customer = mCustomerRepository.findById(customerId)

            val list = mSubscriptionRepository.findAllSubscriptionByCustomer(customer = customer.get())

            list.map {


                subscriptionsList.add(MapperUtils.getSubscriptionMapperDTO().fromTo(it))
            }

        } catch (e: Exception) {

            response.statusCode = 400
            response.statusMessage = "Error while fetching result: ${e.message}"
        }


        response.result = subscriptionsList

        return response
    }

    override fun getNewsPaperList(): ResponseListDTO<NewsPaperDTO> {
        val response = ResponseListDTO<NewsPaperDTO>()

        val newsPaperList: MutableList<NewsPaperDTO> = mutableListOf()
        val list = mNewsPapersRepository.findAll().toList()

        list.map {

            newsPaperList.add(MapperUtils.getNewsDTOMapper().fromTo(it))
        }

        response.result = newsPaperList

        return response
    }
}