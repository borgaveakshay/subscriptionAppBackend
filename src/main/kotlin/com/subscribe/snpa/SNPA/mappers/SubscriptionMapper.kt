package com.subscribe.snpa.SNPA.mappers

import com.subscribe.snpa.SNPA.entities.Subscriptions
import com.subscribe.snpa.SNPA.models.SubscribeDTO
import com.subscribe.snpa.SNPA.utils.MapperUtils

class SubscriptionMapper : Mapper<SubscribeDTO, Subscriptions>() {


    override fun fromTo(from: SubscribeDTO): Subscriptions {
        return Subscriptions(id = from.subscriptionId,
                subscriptionStart = from.SubscriptionStartDate,
                subscriptionEnd = from.SubscriptionEndDate,
                customer = MapperUtils.getCustomerMapper().fromTo(from.customerDTO),
                vendor = MapperUtils.getVendorMapper().fromTo(from.vendorDTO),
                newsPapers = MapperUtils.getNewsMapper().fromTo(from.newsPaperDTO))
    }
}

class SubscriptionMapperDTO : Mapper<Subscriptions, SubscribeDTO>() {

    override fun fromTo(from: Subscriptions): SubscribeDTO = SubscribeDTO(subscriptionId = from.id,
            SubscriptionEndDate = from.subscriptionEnd,
            SubscriptionStartDate = from.subscriptionStart,
            vendorDTO = MapperUtils.getVendorMapperDTO().fromTo(from.vendor),
            customerDTO = MapperUtils.getCustomerMapperDTO().fromTo(from.customer),
            newsPaperDTO = MapperUtils.getNewsDTOMapper().fromTo(from.newsPapers))
}