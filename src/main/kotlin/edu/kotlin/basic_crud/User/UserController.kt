package edu.kotlin.basic_crud.User

import edu.kotlin.basic_crud.Config.Security.JwtAuthenticationToken
import edu.kotlin.basic_crud.Config.Security.JwtUtil
import edu.kotlin.basic_crud.exceptions.UserNotFoundException
import edu.kotlin.basic_crud.utils.ApiResponse
import edu.kotlin.basic_crud.utils.ApiResponse.Companion.error
import edu.kotlin.basic_crud.utils.ApiResponse.Companion.success
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.Authentication
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.http.HttpResponse
import java.util.*
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/api")
class UserController(
  private val userService: UserService,
  private val jwtUtil: JwtUtil,
  private val authenticationManager: AuthenticationManager
) {

  @Value("\${jwt.header.access}")
  lateinit var accessHeader: String

  @Value("\${jwt.header.refresh}")
  lateinit var refreshHeader: String

  @PostMapping("/login")
  fun userLogin(@RequestBody loginDto: LoginDto, response: HttpServletResponse): ApiResponse.ApiResults<Boolean> = try {
    // authentication Manager를 통해 인증 로직 호출
    val authentication: Authentication = authenticationManager.authenticate(JwtAuthenticationToken(principal = loginDto.principal, credentials = loginDto.credentials, authorities = null))
    val signinUser: User = authentication.details as User

    val accessToken = jwtUtil.generateAccess(signinUser)
    val refreshToken = jwtUtil.generateRefresh(signinUser)

    response.setHeader(accessHeader, accessToken)
    response.setHeader(refreshHeader, refreshToken)

    success(true)
  } catch (e: Exception) {
    throw Exception(e.message)
  }


  @PostMapping("/signup")
  fun userSignUp(@RequestBody user: User): ApiResponse.ApiResults<User> = try {
    success(userService.signUp(user))
  } catch (e: Exception) {
    throw Exception(e.message)
  }

  @GetMapping("/users")
  fun getAllUsers(): ApiResponse.ApiResults<MutableList<User>> = try {
    success(userService.getAllUsers())
  } catch (e: Exception) {
    throw Exception(e.message)
  }


  @GetMapping("/user/{seq}")
  fun getUserById(@PathVariable("seq") seq: Long): ApiResponse.ApiResults<User> {
    return try {
      success(userService.getUserBySeq(seq).get())
    } catch (e: Exception) {
      throw Exception(e.message)
    }
  }

  @GetMapping("/user")
  fun getMyProfile(@AuthenticationPrincipal author: User?): ApiResponse.ApiResults<User> = try {
    success(author)
  } catch (e: Exception) {
    throw Exception(e.message)
  }

}