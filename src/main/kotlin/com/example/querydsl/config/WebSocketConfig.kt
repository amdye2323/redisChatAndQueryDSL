package com.example.querydsl.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker // WebSocket을 통한 메세징 기능을 활성화 시킴
class WebSocketConfig: WebSocketMessageBrokerConfigurer {

    // Websocket 연결을 위한 엔드포인트를 지정해줍니다.
    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/ws").setAllowedOrigins("*")
    }

    // 메세지를 주고받을 엔드포인트에 대한 prefiex를 정해줍니다.
    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        // 클라이언트가 구독 할 때
        registry.enableSimpleBroker("/sub")
        // 서버가 목적지 일 때
        registry.setApplicationDestinationPrefixes("/pub")
    }
}