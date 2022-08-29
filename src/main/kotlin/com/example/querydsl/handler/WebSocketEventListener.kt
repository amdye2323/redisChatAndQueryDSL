//package com.example.querydsl.handler
//
//import com.example.querydsl.domain.ChatMessage
//import com.example.querydsl.enum.MessageType
//import org.slf4j.Logger
//import org.slf4j.LoggerFactory
//import org.springframework.context.event.EventListener
//import org.springframework.messaging.simp.SimpMessagingTemplate
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor
//import org.springframework.stereotype.Component
//import org.springframework.web.socket.messaging.SessionConnectEvent
//import org.springframework.web.socket.messaging.SessionDisconnectEvent
//
//@Component
//class WebSocketEventListener(
//    private val messagingTemplate: SimpMessagingTemplate?
//) {
//    private val logger: Logger = LoggerFactory.getLogger(WebSocketEventListener::class.java)
//
//    @EventListener
//    fun handleWebSocketConnectionListener(event: SessionConnectEvent?){
//        logger.info("Received a new web socket connection")
//    }
//
//    @EventListener
//    fun handleWebSocketDisconnectListener(event: SessionDisconnectEvent){
//        val headerAccessor = StompHeaderAccessor.wrap(event.message)
//        val username = headerAccessor.sessionAttributes!!["username"] as String?
//
//        if(username != null){
//            logger.info("User Disconnected: ${username}")
//            val chatMessage = ChatMessage(MessageType.LEAVE, "" , username)
//
//            messagingTemplate!!.convertAndSend("/topic/public" , chatMessage)
//        }
//    }
//
//}