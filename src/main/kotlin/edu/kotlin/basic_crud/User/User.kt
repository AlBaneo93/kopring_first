package edu.kotlin.basic_crud.User

enum class Role(){

}

data class User(val seq: Long, val id: String, val password: String, val name: String, val isAdmin: Boolean, val role: Role)
