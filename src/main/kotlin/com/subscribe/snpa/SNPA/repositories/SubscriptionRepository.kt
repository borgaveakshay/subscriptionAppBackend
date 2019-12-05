package com.subscribe.snpa.SNPA.repositories

import com.subscribe.snpa.SNPA.entities.Customer
import com.subscribe.snpa.SNPA.entities.Subscriptions
import com.subscribe.snpa.SNPA.entities.Vendor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SubscriptionRepository : CrudRepository<Subscriptions, Int> {

    fun findAllSubscriptionsByVendor(vendor: Vendor): List<Subscriptions>

    fun findAllSubscriptionByCustomer(customer: Customer): List<Subscriptions>
}