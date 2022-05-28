package edu.kotlin.basic_crud.User

import edu.kotlin.basic_crud.Doamin.User.User
import edu.kotlin.basic_crud.Doamin.User.UserRole
import org.junit.jupiter.api.Test

import java.time.LocalDateTime

class UserServiceImplTest(private val repository: UserRepository) {


  @Test
  fun signUp() {
    val initalCount = repository.count()
    val user: User = User(
      0, "eclementss@webeden.co.uk", "1234", "Ester", true, setOf(UserRole.ADMIN), LocalDateTime.now(), LocalDateTime.now(), mutableSetOf()
    )

    repository.save(user)

    val afterCount = repository.count()

    assert(initalCount != afterCount)
  }

}