package com.charlottewiltshire0.updaterinstaller.api.controller.user

import com.charlottewiltshire0.updaterinstaller.api.controller.dto.request.user.CreateUserRequest
import com.charlottewiltshire0.updaterinstaller.api.controller.dto.request.user.UpdateUserRequest
import com.charlottewiltshire0.updaterinstaller.api.controller.dto.responce.user.UserResponse
import com.charlottewiltshire0.updaterinstaller.api.controller.dto.responce.user.UserSearchResponse
import com.charlottewiltshire0.updaterinstaller.api.service.user.UserService
import org.springframework.web.bind.annotation.*

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

    @GetMapping
    fun searchUser(
        @RequestParam q: String?,
        @RequestParam sort: String?,
        @RequestParam fields: String?,
        @RequestParam("include_fields") includeFields: Boolean,
        @RequestParam("page", defaultValue = "0") page: Int,
        @RequestParam("per_page", defaultValue = "10") perPage: Int
    ): UserSearchResponse {
        return userService.searchUser(q, sort, fields, includeFields, page, perPage)
    }
}