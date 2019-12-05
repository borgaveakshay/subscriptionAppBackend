package com.subscribe.snpa.SNPA

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration


@SpringBootApplication
@Configuration
class SnpaApplication


fun main(args: Array<String>) {
    runApplication<SnpaApplication>(*args)
}

