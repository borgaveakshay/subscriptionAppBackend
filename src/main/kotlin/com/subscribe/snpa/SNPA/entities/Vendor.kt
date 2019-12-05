package com.subscribe.snpa.SNPA.entities

import javax.persistence.*

@Entity
data class Vendor(@GeneratedValue(strategy = GenerationType.AUTO)
                  @Id
                  @Column(name = "vendor_id")
                  var id: Int = 0,
                  var name: String,
                  var email: String,
                  @ManyToOne
                  var area: Area,
                  @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
                  @JoinTable(name = "vendor_news_paper", joinColumns = [JoinColumn(name = "vendor_id")], inverseJoinColumns = [JoinColumn(name = "news_paper_id")])
                  var newsPapers: Set<NewsPapers> = emptySet())