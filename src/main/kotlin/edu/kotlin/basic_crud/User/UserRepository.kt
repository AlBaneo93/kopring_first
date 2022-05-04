package edu.kotlin.basic_crud.User

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Long, User> {
    fun findById(id: String): User
}