package com.example.querydsl.entity

import org.springframework.data.redis.core.RedisHash
import javax.persistence.Id

@RedisHash("member")
data class Rmember (
    @Id
    val id: String? = null,
    val name: String? = null,
    val email: String? = null,
    val age: Int? = null,
        )