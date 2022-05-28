package edu.kotlin.basic_crud.User

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class UserServiceImplTest @Autowired constructor(private val repository: UserRepository) {

  @Test
  @DisplayName("회원가입 테스트")
  fun signUp() {
    val user = User(
      seq = 0,
      id = "test@email.com",
      password = "test",
      name = "test",
      isAdmin = true,
      createdAt = LocalDateTime.now(),
      updatedAt = LocalDateTime.now(),
      authorities = mutableSetOf(UserRole.USER),
      joinGroups = mutableSetOf()
    )
    println("before seq : ${user.seq}")
    repository.save(user)
    println("after seq : ${user.seq}")
  }

}