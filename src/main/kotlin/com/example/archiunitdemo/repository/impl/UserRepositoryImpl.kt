package com.example.archiunitdemo.repository.impl

import com.example.archiunitdemo.entity.User
import com.example.archiunitdemo.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserRepositoryImpl : UserRepository {

    val userMap = hashMapOf(1L to User(1L, "test"))

    override fun getById(id: Long): User? {
        return userMap.get(1L)
    }
}