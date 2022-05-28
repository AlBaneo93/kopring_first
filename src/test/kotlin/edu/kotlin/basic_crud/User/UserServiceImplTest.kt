package edu.kotlin.basic_crud.User

import org.junit.jupiter.api.Test

import java.time.LocalDateTime

class UserServiceImplTest(private val repository: UserRepository) {


  @Test
  fun signUp() {
    var user: User = User(
      0, "eclementss@webeden.co.uk", "1234", "Ester", true, setOf(UserRole.ADMIN), LocalDateTime.now(), LocalDateTime.now()
    )

  }

}