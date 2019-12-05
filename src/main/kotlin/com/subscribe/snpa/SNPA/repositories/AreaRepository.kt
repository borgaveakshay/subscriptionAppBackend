package com.subscribe.snpa.SNPA.repositories

import com.subscribe.snpa.SNPA.entities.Area
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AreaRepository : CrudRepository<Area, Int>