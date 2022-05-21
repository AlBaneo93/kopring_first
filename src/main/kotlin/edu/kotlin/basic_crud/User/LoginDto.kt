package edu.kotlin.basic_crud.User

data class LoginDto(
  val principal: String,
  val credentials: String
)