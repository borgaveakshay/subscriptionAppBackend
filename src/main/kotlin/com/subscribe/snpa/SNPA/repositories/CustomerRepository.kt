package com.subscribe.snpa.SNPA.repositories

import com.subscribe.snpa.SNPA.entities.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : CrudRepository<Customer, Int> {


    fun findByEmail(email: String): Customer?

}