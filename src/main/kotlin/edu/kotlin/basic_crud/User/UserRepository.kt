package edu.kotlin.basic_crud.User

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

  fun findUserById(name: String):User?
}