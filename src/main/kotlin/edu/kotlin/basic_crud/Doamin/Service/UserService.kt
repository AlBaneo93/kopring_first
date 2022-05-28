package edu.kotlin.basic_crud.Doamin.Service

import edu.kotlin.basic_crud.Doamin.models.User.User
import edu.kotlin.basic_crud.Doamin.models.User.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

interface UserService : UserDetailsService {

  fun login(user: User): User

  fun getAllUsers(): MutableList<User>


  fun getUserBySeq(seq: Long): Optional<User>
  fun signUp(user: User): User
}

@Service
open class UserserviceImpl(private val repository: UserRepository) : UserService {

  override fun login(user: User): User {
    return repository.save(user)
  }

  override fun getAllUsers(): MutableList<User> {
    return repository.findAll()
  }


  override fun getUserBySeq(seq: Long): Optional<User> {
    return repository.findById(seq)
  }

  override fun signUp(user: User): User {
    return repository.save(user)
  }

  override fun loadUserByUsername(username: String?): UserDetails {
    return repository.findUserById(username!!) ?: throw UsernameNotFoundException("${username}을 찾을 수 없습니다.")
  }

}