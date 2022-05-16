package edu.kotlin.basic_crud.exceptions

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.*

@RestControllerAdvice
class ExceptionController {

  @ExceptionHandler(JwtExtractException::class)
  fun JwtExtractExceptionHandler(): String {
    println()
//    return ResponseEntity(mutableMapOf("msg", "토큰 추출 실패. 접근 거부 됨."))
    return "토큰 추출 실패. 접근 거부 됨."
  }
}