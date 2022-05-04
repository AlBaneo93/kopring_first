package edu.kotlin.basic_crud.User

import org.springframework.stereotype.Service
import java.util.Optional

interface UserService {
    fun login(): User

    fun getAllUsers(): MutableList<Long>

    fun getUserById(id: String): User?
}

@Service
class UserServiceImpl(val repository: UserRepository) : UserService {
    override fun login(): User {
        TODO("Not yet implemented")
    }

    override fun getAllUsers(): MutableList<Long> {
        return repository.findAll()
    }

    override fun getUserById(id: String): User? {
        return repository.findById(id)
    }

}