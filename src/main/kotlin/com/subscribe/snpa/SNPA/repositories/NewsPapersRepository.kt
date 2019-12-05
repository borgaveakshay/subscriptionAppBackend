package com.subscribe.snpa.SNPA.repositories

import com.subscribe.snpa.SNPA.entities.NewsPapers
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface NewsPapersRepository : CrudRepository<NewsPapers, Int>