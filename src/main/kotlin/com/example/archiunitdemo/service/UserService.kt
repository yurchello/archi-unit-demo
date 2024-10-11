package com.example.archiunitdemo.service

import com.example.archiunitdemo.dto.UserDto

interface UserService {
    fun getById(id:Long): UserDto;
}