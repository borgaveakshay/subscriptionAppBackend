package com.subscribe.snpa.SNPA.entities

import javax.persistence.*

@Entity
data class Customer(@GeneratedValue(strategy = GenerationType.AUTO)
                    @Id
                    var id: Int = 0,
                    var name: String,
                    var latitude: Double,
                    var longitude: Double,
                    var address: String,
                    var email: String,
                    @OneToOne
                    var area: Area)


