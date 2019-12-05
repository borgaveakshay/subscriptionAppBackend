package com.subscribe.snpa.SNPA.entities

import java.sql.Date
import javax.persistence.*

@Entity
data class Subscriptions(@GeneratedValue(strategy = GenerationType.AUTO)
                         @Id
                         var id: Int = 0,
                         var subscriptionStart: Date,
                         var subscriptionEnd: Date,
                         @ManyToOne(cascade = [CascadeType.REFRESH], fetch = FetchType.LAZY)
                         var customer: Customer,
                         @ManyToOne(cascade = [CascadeType.REFRESH], fetch = FetchType.LAZY)
                         var vendor: Vendor,
                         @ManyToOne(cascade = [CascadeType.REFRESH], fetch = FetchType.LAZY)
                         var newsPapers: NewsPapers)