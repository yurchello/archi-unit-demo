package com.example.archiunitdemo.controller

import com.example.archiunitdemo.dto.UserDto
import com.example.archiunitdemo.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/user")
class UserController(
        private val userService: UserService
) {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): UserDto {
        return userService.getById(id)
    }

}