package com.subscribe.snpa.SNPA.mappers

abstract class Mapper<in T, E> {


    abstract fun fromTo(from: T): E
}