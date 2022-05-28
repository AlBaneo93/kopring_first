package edu.kotlin.basic_crud.Infrastructures.Config.Security

import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class CustomAuthenticationEntryPoint : AuthenticationEntryPoint {

  override fun commence(request: HttpServletRequest?, response: HttpServletResponse?, authException: AuthenticationException?) {
    println("Custom Authentication Entry Point")
    response!!.apply {
      // NOTE 2022-05-17 : Senderror를 먼저 쓰면 streamdl 끊겨 이후의 메시지는 보이지 않는다.
      // NOTE 2022-05-17 : 그러므로, 커스텀한 메시지를 보내려면 outputstream만 이용한다
      status = HttpStatus.UNAUTHORIZED.value()
//      sendError(HttpServletResponse.SC_UNAUTHORIZED, "인증 실패 오류가 발생했습니다")
      contentType = "application/json"
      outputStream.apply {
        val message = "HTTP Status 401 - " + authException?.message
//        val objectMapper = ObjectMapper()
//        val res = ResponseEntity.ok(message)
//        objectMapper.writeValue(this, res)
        println(message)

        flush()
      }
    }
  }
}