package edu.kotlin.basic_crud.Config.Security

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority

class JwtAuthenticationToken : AbstractAuthenticationToken {

  private var credentials: String?
  private var principal: String

  constructor(
    credentials: String?, principal: String, authorities: MutableCollection<out GrantedAuthority>?
  ) : super(authorities) {
    this.credentials = credentials
    this.principal = principal
  }

  constructor(credentials: String, principal: String) : super(null) {
    this.credentials = credentials
    this.principal = principal
  }

  override fun getCredentials(): String? {
    return this.credentials
  }

  override fun getPrincipal(): String {
    return this.principal
  }
}