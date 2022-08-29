package com.example.querydsl.config

import com.example.querydsl.domain.CoffeDto
import com.example.querydsl.handler.RedisMessageDtoSubscriber
import com.example.querydsl.handler.RedisMessageStringSubscriber
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
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
            addMessageListener(messageDtoListener(),topic2())
        }
    }

    @Bean
    fun topic1():ChannelTopic{
        return ChannelTopic("ch01")
    }

    @Bean
    fun topic2():ChannelTopic{
        return ChannelTopic("ch02")
    }

    @Bean
    fun messageDtoListener():MessageListenerAdapter{
        return MessageListenerAdapter(RedisMessageDtoSubscriber())
    }

    @Bean
    fun stringValueRedisTemplate():RedisTemplate<String, String>{
        return RedisTemplate<String, String>().apply {
            keySerializer=StringRedisSerializer()
            valueSerializer=StringRedisSerializer()
            setConnectionFactory(redisConnectionFactory())
        }
    }

    @Bean
    fun coffeeDTORedisTemplate():RedisTemplate<String,CoffeDto>{
        return RedisTemplate<String,CoffeDto>().apply {
            keySerializer=StringRedisSerializer()
            valueSerializer=Jackson2JsonRedisSerializer(CoffeDto::class.java)
            setConnectionFactory(redisConnectionFactory())
        }
    }
}