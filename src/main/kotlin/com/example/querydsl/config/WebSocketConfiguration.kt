//package com.example.querydsl.config
//
//import com.example.querydsl.handler.WebSocketHandler
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.web.socket.config.annotation.EnableWebSocket
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
//
//@Configuration
//@EnableWebSocket
//class WebSocketConfiguration: WebSocketConfigurer {
//    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
//        registry.addHandler(signalingSocketHandler(), "/room")
//            .setAllowedOrigins("*")
//    }
//
//    @Bean
//    fun signalingSocketHandler():WebSocketHandler{
//        return WebSocketHandler()
//    }
//}