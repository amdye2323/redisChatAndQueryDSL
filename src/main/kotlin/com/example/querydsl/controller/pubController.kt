package com.example.querydsl.controller

import com.example.querydsl.domain.CoffeDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class pubController (
    @Autowired private val stringValueRedisTemplate:RedisTemplate<String,String>,
    @Autowired private val coffeeDTORedisTemplate:RedisTemplate<String,CoffeDto>
        ){

    @GetMapping("/pub/message")
    fun sendToTextMessage(){
        stringValueRedisTemplate.convertAndSend("ch01","Coffee, latee")
    }

    @GetMapping("/pub/messageDto")
    fun sendToDTOMessage(){
        val coffeeDTO = CoffeDto("latte", 1100)
        coffeeDTORedisTemplate.convertAndSend("ch02", coffeeDTO)
    }
}