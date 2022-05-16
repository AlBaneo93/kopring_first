package edu.kotlin.basic_crud.Config.Security

import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Slf4j
@Component
class CustomDeniedHandler : AccessDeniedHandler {

  override fun handle(request: HttpServletRequest?, response: HttpServletResponse?, accessDeniedException: AccessDeniedException?) {
println("액세스 거부 핸들러")
    response!!.sendError(HttpStatus.FORBIDDEN.value(), "Access Denied has no authorize info")
    response.writer.println("접근 거부합니다")
  }
}
