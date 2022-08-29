package com.example.querydsl.domain

import com.example.querydsl.enum.MessageType

data class ChatMessage(
    var type: MessageType,
    var content: String?,
    var sender: String
)