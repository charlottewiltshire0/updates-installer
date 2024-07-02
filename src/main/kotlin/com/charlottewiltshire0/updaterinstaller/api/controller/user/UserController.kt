package com.charlottewiltshire0.updaterinstaller.api.controller.user

import com.charlottewiltshire0.updaterinstaller.api.controller.dto.request.user.CreateUserRequest
import com.charlottewiltshire0.updaterinstaller.api.service.user.UserService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
class UserController(
    private val userService: UserService
) {

    @PostMapping()
    fun createUser(@RequestBody body: CreateUserRequest) {
        userService.createUser(body)
    }
}