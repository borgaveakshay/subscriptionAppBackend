package com.subscribe.snpa.SNPA.entities

import javax.persistence.*

@Entity
data class Area(@GeneratedValue(strategy = GenerationType.AUTO)
                @Id
                var id: Int,
                var name: String = "")