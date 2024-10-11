package com.example.archiunitdemo.service.impl

import com.example.archiunitdemo.dto.UserDto
import com.example.archiunitdemo.repository.UserRepository
import com.example.archiunitdemo.service.UserService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class UserServiceImpl(
        private val userRepository: UserRepository) : UserService {
    override fun getById(id: Long): UserDto {
        val user = userRepository.getById(id)
        if (user==null){
            throw RuntimeException()
        }
        return UserDto(user.id, user.name)
    }
}