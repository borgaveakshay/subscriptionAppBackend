package com.subscribe.snpa.SNPA.mappers

import com.subscribe.snpa.SNPA.entities.Customer
import com.subscribe.snpa.SNPA.models.CustomerDTO
import com.subscribe.snpa.SNPA.utils.MapperUtils


class CustomerMapper : Mapper<CustomerDTO, Customer>() {

    override fun fromTo(from: CustomerDTO): Customer {
        return Customer(name = from.name,
                latitude = from.latitude,
                longitude = from.longitude,
                address = from.address,
                email = from.email,
                area = MapperUtils.getAreaMapper().fromTo(from.areaDTO))
    }
}

class CustomerMapperDTO : Mapper<Customer, CustomerDTO>() {

    override fun fromTo(from: Customer): CustomerDTO {
        return CustomerDTO(name = from.name, email = from.email, longitude = from.longitude, latitude = from.latitude, address = from.address, customerId = from.id, areaDTO = MapperUtils.getAreaMapperDTO().fromTo(from.area))
    }
}