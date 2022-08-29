package com.example.querydsl.domain

import java.io.Serializable

data class CoffeDto (
    private val name:String,
    private val price: Int
        ): Serializable