package edu.kotlin.basic_crud.Config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class RedisConfig(
  @Value("\${spring.redis.host}")
  private val host: String,
  @Value("\${spring.redis.port}")
  private val port: String
) {

  @Bean
  fun redisConnectionFactory(): RedisConnectionFactory {
    return LettuceConnectionFactory(host, port.toInt())
  }

  @Bean
  fun redisTemplate(): RedisTemplate<Any, Any> {
    val redisTemplate: RedisTemplate<Any, Any> = RedisTemplate()
    redisTemplate.setConnectionFactory(redisConnectionFactory())
    return redisTemplate
  }
}