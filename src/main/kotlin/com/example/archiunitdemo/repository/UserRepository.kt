package com.example.archiunitdemo.repository

import com.example.archiunitdemo.entity.User
import org.springframework.stereotype.Repository

@Repository
interface UserRepository {
    fun getById(id:Long): User?
}