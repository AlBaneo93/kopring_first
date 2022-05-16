package edu.kotlin.basic_crud.Config.Security

import org.ietf.jgss.GSSException.UNAUTHORIZED
import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class CustomAuthenticationEntryPoint : AuthenticationEntryPoint {

  override fun commence(request: HttpServletRequest?, response: HttpServletResponse?, authException: AuthenticationException?) {
    println("Auth 엔트리 포인트")
    response?.apply {
      status = HttpStatus.UNAUTHORIZED.value()
      contentType = "application/json;charset=utf-8"
      sendError(HttpServletResponse.SC_UNAUTHORIZED, "인증 실패 오류가 발생했습니다")
      writer.apply {
        println("HTTP Status 401 - " + authException?.message);
        flush()
      }
    }
    println("엔트리포인트 작업 완료")
  }
}