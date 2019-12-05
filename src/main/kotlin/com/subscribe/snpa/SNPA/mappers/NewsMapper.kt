package com.subscribe.snpa.SNPA.mappers

import com.subscribe.snpa.SNPA.entities.NewsPapers
import com.subscribe.snpa.SNPA.models.NewsPaperDTO

class NewsMapper : Mapper<NewsPaperDTO, NewsPapers>() {

    override fun fromTo(from: NewsPaperDTO): NewsPapers {
        return NewsPapers(id = from.newsPaperId, name = from.newsPaperName, price = from.newsPaperPrice)
    }
}


class NewsDTOMapper : Mapper<NewsPapers, NewsPaperDTO>() {

    override fun fromTo(from: NewsPapers): NewsPaperDTO {
        return NewsPaperDTO(newsPaperId = from.id, newsPaperName = from.name, newsPaperPrice = from.price)
    }
}