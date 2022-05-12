package edu.kotlin.basic_crud.Config.Security

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority

data class JwtAuthentication(val seq: Long, val id: String)