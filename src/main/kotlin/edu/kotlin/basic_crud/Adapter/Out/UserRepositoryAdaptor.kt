package edu.kotlin.basic_crud.Adapter.Out

import edu.kotlin.basic_crud.Doamin.models.User.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepositoryAdaptor : JpaRepository<User, Long> {

  fun findUserById(name: String): User?
}