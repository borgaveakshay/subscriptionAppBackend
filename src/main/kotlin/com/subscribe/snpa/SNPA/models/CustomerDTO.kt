package com.subscribe.snpa.SNPA.models

data class CustomerDTO(var name: String,
                       var customerId: Int = 0,
                       var email: String,
                       var latitude: Double,
                       var longitude: Double,
                       var address: String,
                       var areaDTO: AreaDTO)