//package com.example.querydsl.handler
//
//import com.example.querydsl.domain.Message
//import kotlinx.serialization.decodeFromString
//import kotlinx.serialization.json.Json
//import org.slf4j.Logger
//import org.slf4j.LoggerFactory
//import org.springframework.web.socket.CloseStatus
//import org.springframework.web.socket.TextMessage
//import org.springframework.web.socket.WebSocketSession
//import org.springframework.web.socket.handler.TextWebSocketHandler
//import kotlin.jvm.Throws
//
//open class WebSocketHandler: TextWebSocketHandler() {
//    private val logger: Logger = LoggerFactory.getLogger(WebSocketEventListener::class.java)
//
//    private val sessions:MutableMap<String, WebSocketSession> = mutableMapOf()
//
//    // 웹 소켓 연결
//    @Throws(Exception::class)
//    override fun afterConnectionEstablished(session: WebSocketSession) {
//        var sessingId:String = session.id
//
//        sessions.put(sessingId, session) // 세션 저장
//
//        val message:Message = Message(
//            sender = sessingId,
//            receiver = "all",
//        )
//        message.newConnect()
//
//        sessions.values.forEach{
//            s ->
//            try {
//                run {
//                    if (!s.id.equals(sessingId)) {
//                        s.sendMessage(TextMessage(message.toString().toByteArray()))
//                    }
//                }
//            } catch (e:Exception){
//                e.printStackTrace()
//            }
//
//        }
//    }
//
//    // 양방향 데이터 통신
//    override fun handleTextMessage(session: WebSocketSession, textMessage: TextMessage) {
//        val message:Message = Json.decodeFromString(textMessage.payload)
//        message.setSender(session.id)
//
//        val receiver: WebSocketSession? = sessions.get(message.)
//
//        if(receiver != null && receiver.isOpen){
//            receiver.sendMessage(TextMessage(message.toString().toByteArray()))
//        }
//    }
//
//    // 소켓 연결 종료
//    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
//        var sessionId:String = session.id
//
//        sessions.remove(sessionId)
//
//        val message:Message = Message()
//        message.closeConnect()
//        message.setSender(sessionId)
//
//        sessions.values.forEach{ s ->
//            try {
//                s.sendMessage(TextMessage(message.toString().toByteArray()))
//            } catch (e:Exception){
//                e.printStackTrace()
//            }
//        }
//    }
//
//    // 소켓 통신 에러
//    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
//        super.handleTransportError(session, exception)
//    }
//}