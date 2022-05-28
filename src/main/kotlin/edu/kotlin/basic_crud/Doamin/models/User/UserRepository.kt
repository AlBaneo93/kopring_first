package edu.kotlin.basic_crud.Doamin.models.User

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {

  fun findUserById(name: String): User?
}