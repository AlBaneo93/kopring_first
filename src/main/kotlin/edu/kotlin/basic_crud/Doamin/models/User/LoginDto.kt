package edu.kotlin.basic_crud.Doamin.models.User

data class LoginDto(
  val principal: String,
  val credentials: String
)