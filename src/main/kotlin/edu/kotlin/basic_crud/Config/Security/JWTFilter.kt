package edu.kotlin.basic_crud.Config.Security

import edu.kotlin.basic_crud.exceptions.JwtExtractException
import io.jsonwebtoken.JwtException
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException.Unauthorized
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Slf4j
@Component
class JWTFilter() : OncePerRequestFilter() {

  override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
    logger.debug("user access to jwtfilter")
    println("사용자 필터 접근 함")
    try {
      val access: String = request.getHeader("access")
      val refresh: String = request.getHeader("refresh")
      println("토큰 추출 성공")
    } catch (e: Exception) {
      logger.debug("${e.message}")
      println("토큰 추출 실패")
      throw JwtExtractException("${e.message}")
    }

    filterChain.doFilter(request, response)
  }
}