package com.charlottewiltshire0.updaterinstaller.api.controller.user

import com.charlottewiltshire0.updaterinstaller.api.controller.dto.request.user.CreateUserRequest
import com.charlottewiltshire0.updaterinstaller.api.controller.dto.request.user.UpdateUserRequest
import com.charlottewiltshire0.updaterinstaller.api.controller.dto.responce.UserResponse
import com.charlottewiltshire0.updaterinstaller.api.service.user.UserService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @PostMapping
    fun createUser(@RequestBody createUserRequest: CreateUserRequest): UserResponse {
        return userService.createUser(createUserRequest)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): UserResponse {
        return userService.getUserById(id)
    }

    @PatchMapping("/{id}")
    fun updateUser(
        @PathVariable id: Long,
        @RequestBody updateUserRequest: UpdateUserRequest
    ): UserResponse {
        return userService.updateUser(id, updateUserRequest)
    }

    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable id: Long): String {
        return userService.deleteUserById(id)
    }
}