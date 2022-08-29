package com.example.querydsl.config

import com.example.querydsl.handler.RedisMessageStringSubscriber
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfig{

    @Bean
    fun redisConnectionFactory():RedisConnectionFactory{
        return LettuceConnectionFactory()
    }

    @Bean
    fun messageStringListener():MessageListenerAdapter{
        return MessageListenerAdapter(RedisMessageStringSubscriber())
    }

    @Bean
    fun redisContainer():RedisMessageListenerContainer{
        return RedisMessageListenerContainer().apply {
            setConnectionFactory(redisConnectionFactory())
            addMessageListener(messageStringListener(),topic1())
        }
    }

    @Bean
    fun topic1():ChannelTopic{
        return ChannelTopic("ch01")
    }

    @Bean
    fun stringValueRedisTemplate():RedisTemplate<String, String>{
        return RedisTemplate<String, String>().apply {
            keySerializer=StringRedisSerializer()
            valueSerializer=StringRedisSerializer()
            setConnectionFactory(redisConnectionFactory())
        }
    }
}