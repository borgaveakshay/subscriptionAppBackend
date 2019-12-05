package com.subscribe.snpa.SNPA.entities

import javax.persistence.*

@Entity
data class NewsPapers(@GeneratedValue(strategy = GenerationType.AUTO)
                      @Id
                      @Column(name = "news_paper_id")
                      var id: Int,
                      var name: String,
                      var price: Double)
//                      @ManyToMany(mappedBy = "newsPapers", fetch = FetchType.LAZY)
//                      var vendors: Set<Vendor> = emptySet()