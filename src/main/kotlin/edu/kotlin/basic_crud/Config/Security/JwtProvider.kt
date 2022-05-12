package edu.kotlin.basic_crud.Config.Security

import edu.kotlin.basic_crud.User.User
import edu.kotlin.basic_crud.User.UserService
import edu.kotlin.basic_crud.exceptions.UserNotFoundException
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder

class JwtProvider(
  private val userService: UserService,
  private val passwordEncoder: PasswordEncoder
) : AuthenticationProvider {

  override fun authenticate(authentication: Authentication?): Authentication {

    val authToken = authentication as JwtAuthenticationToken

    val email: String = authToken.principal
    val password: String = authToken.credentials ?: ""
    val tmpUser: User = userService.loadUserByUsername(email) as User

    if (!passwordEncoder.matches(password, tmpUser.password))
      throw BadCredentialsException("Bad Credentials Exception for ${email}")

    val userJwtAuthenticate: JwtAuthenticationToken = JwtAuthenticationToken(principal = tmpUser.username, credentials = null, authorities = tmpUser.authorities)
    userJwtAuthenticate.details = tmpUser
    SecurityContextHolder.getContext().authentication = userJwtAuthenticate
    return userJwtAuthenticate
  }

  override fun supports(authentication: Class<*>?): Boolean {
    return authentication?.isAssignableFrom(JwtAuthenticationToken::class.java) ?: false
  }
}