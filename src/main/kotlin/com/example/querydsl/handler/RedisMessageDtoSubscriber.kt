package com.example.querydsl.handler

import com.example.querydsl.domain.CoffeDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.stereotype.Service

@Service
class RedisMessageDtoSubscriber: MessageListener {

    private val logger: Logger = LoggerFactory.getLogger(RedisMessageStringSubscriber::class.java)

    companion object {
        private val coffeeDTOS:MutableList<CoffeDto> = mutableListOf()
    }
    private val mapper:ObjectMapper = ObjectMapper()

    override fun onMessage(message: Message, pattern: ByteArray?) {
        try {
            val coffee:CoffeDto = mapper.readValue(message.body, CoffeDto::class.java)
            coffeeDTOS.add(coffee)

            logger.info("DTO Message received: " + message.toString())
            logger.info("Total CoffeddDTO's size: " + coffeeDTOS.size)
        } catch (e:Exception){
            e.printStackTrace()
        }
    }

}