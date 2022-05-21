package edu.kotlin.basic_crud.User

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.Optional

interface UserService : UserDetailsService {

  fun login(): User

  fun getAllUsers(): MutableList<User>


  fun getUserBySeq(seq: Long): Optional<User>
  fun signUp(user: User): User
}

@Service
class UserServiceImpl(private val repository: UserRepository) : UserService {

  override fun login(): User {
    TODO("Not yet implemented")
  }

  override fun getAllUsers(): MutableList<User> {
    return repository.findAll()
  }


  override fun getUserBySeq(seq: Long): Optional<User> {
    return repository.findById(seq)
  }

  override fun signUp(user: User): User {
    TODO("Not yet implemented")
  }

  override fun loadUserByUsername(username: String?): UserDetails {
    return repository.findUserById(username!!) ?: throw UsernameNotFoundException("${username}을 찾을 수 없습니다.")
  }

}