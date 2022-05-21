package edu.kotlin.basic_crud.Config.Security

import edu.kotlin.basic_crud.User.User
import edu.kotlin.basic_crud.User.UserService
import edu.kotlin.basic_crud.exceptions.JwtExtractException
import edu.kotlin.basic_crud.exceptions.TokenExpiredException
import edu.kotlin.basic_crud.exceptions.UserNotFoundException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.JwtException
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException.Unauthorized
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Slf4j
@Component
class JWTFilter(
  private val jwtUtil: JwtUtil,
  private val userService: UserService,
  private val redisTemplate: RedisTemplate<Any, Any>,


  ) : OncePerRequestFilter() {

  @Value("\${jwt.header.access}")
  lateinit var accessHeader: String

  @Value("\${jwt.header.refresh}")
  lateinit var refreshHeader: String

  override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
    logger.debug("user access to jwtfilter")

    try {
      val access: String = request.getHeader("access")
      val refresh: String = request.getHeader("refresh")

      if (refresh.isNotBlank()) {
        if (access.isEmpty()) {
          val userSeq: Long = (redisTemplate.opsForValue().get(refresh)!! as Long)
          val loginUser: User = userService.getUserBySeq(seq = userSeq).orElseThrow({ throw UserNotFoundException("") })

          val newAccess = jwtUtil.generateAccess(loginUser)
          val newRefresh = jwtUtil.generateRefresh(loginUser)
          redisTemplate.delete(refresh) // 이전 refresh Token 제거
          redisTemplate.opsForValue().set(newRefresh, userSeq) // 새로 발행된 토큰 저장
          setTokenInHeader(response, newAccess, newRefresh)
        }
      } else {
        logger.info("Token expired.")
        throw TokenExpiredException("Token expired. Please login first")
      }

    } catch (e: Exception) {
      logger.debug("${e.message}")
      throw JwtExtractException("${e.message}")
    }

    filterChain.doFilter(request, response)
  }

  private fun setTokenInHeader(response: HttpServletResponse, accessToken: String, refreshToken: String) {
    response.setHeader(accessHeader, accessToken)
    response.setHeader(refreshHeader, refreshToken)
  }
}