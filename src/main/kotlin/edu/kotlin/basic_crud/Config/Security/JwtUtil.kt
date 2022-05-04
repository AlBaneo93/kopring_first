package edu.kotlin.basic_crud.Config.Security

import edu.kotlin.basic_crud.User.User

class JwtUtil {

    val access_exp: Long = 0
    val refresh_exp: Long = 0

    fun generateAccess(user: User) {}
    fun generateRefresh(user: User) {}
    fun validAccess(token: String) {}
    fun validRefresh(token: String) {}

}