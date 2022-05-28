package edu.kotlin.basic_crud.Infrastructures.Config.Security

import edu.kotlin.basic_crud.Doamin.User.User
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Component
import java.time.Instant
import java.util.*

@Component
@Slf4j
class JwtUtil() {

  private final val access_exp: Long = 5000 // 5sec

  private final val refresh_exp: Long = access_exp * 10 // 50 sec

  private final val token_secret: String = "Kopring_JWT_Secrets"

  private final val signatureAlgorithm: SignatureAlgorithm = SignatureAlgorithm.HS256
  fun generateAccess(user: User): String {
    val headers: MutableMap<String, Any> = mutableMapOf()
    val claims: MutableMap<String, Any> = mutableMapOf()
    return tokenBuilder(headers, claims)
  }

  fun generateRefresh(user: User): String {
    val headers: MutableMap<String, Any> = mutableMapOf()
    val claims: MutableMap<String, Any> = mutableMapOf()
    return tokenBuilder(headers, claims)
  }

  fun validAccess(token: String): Boolean {
    return tokenValidate(token)
  }

  fun validRefresh(token: String): Boolean {
    return tokenValidate(token)
  }

  fun parseToken(token: String): Jws<Claims>  = Jwts.parser().setSigningKey(token_secret).parseClaimsJws(token)


  private fun tokenBuilder(headers: MutableMap<String, Any>, claims: MutableMap<String, Any>): String {
    return Jwts.builder().setHeader(headers).setClaims(claims).signWith(signatureAlgorithm, token_secret).compact()
  }

  private fun tokenValidate(token: String): Boolean {
    // NOTE 2022-05-6, 금, 17:0 : expTime을 빼도 될 듯
    try {
      val jws: Jws<Claims> = Jwts.parser().setSigningKey(token_secret).parseClaimsJws(token)
      return jws.body.expiration.before(Date.from(Instant.now()))
    } catch (e: Exception) {
      println("Token Parse Error caused by : ${e.cause}")
      return false
    }
  }

}