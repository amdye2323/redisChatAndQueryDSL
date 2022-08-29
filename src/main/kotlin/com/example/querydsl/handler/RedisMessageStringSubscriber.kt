package com.example.querydsl.handler

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.stereotype.Service

@Service
class RedisMessageStringSubscriber: MessageListener {
    private val logger: Logger = LoggerFactory.getLogger(RedisMessageStringSubscriber::class.java)

    override fun onMessage(message: Message, pattern: ByteArray?) {
        logger.info("String Message Received"+ message.toString())
    }
}