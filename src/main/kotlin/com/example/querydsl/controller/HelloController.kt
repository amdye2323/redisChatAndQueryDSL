package com.example.querydsl.controller

import com.example.querydsl.domain.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @Autowired
    val simpMessageSendingOperations: SimpMessageSendingOperations? = null

    @MessageMapping("/hello")
    fun message(@Payload message:Message){
        simpMessageSendingOperations?.convertAndSend("/sub/channel/"+message.getChannelId(), message)
    }

}