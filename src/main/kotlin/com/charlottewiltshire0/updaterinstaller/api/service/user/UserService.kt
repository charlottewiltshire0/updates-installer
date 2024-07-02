package com.charlottewiltshire0.updaterinstaller.api.service.user

import com.charlottewiltshire0.updaterinstaller.api.controller.dto.request.user.CreateUserRequest
import com.charlottewiltshire0.updaterinstaller.api.controller.dto.request.user.UpdateUserRequest
import com.charlottewiltshire0.updaterinstaller.api.controller.dto.responce.UserResponse

interface UserService {

    fun createUser(createUserRequest: CreateUserRequest): UserResponse

    fun getUserById(id: Long): UserResponse

    fun deleteUserById(id: Long): String

    fun updateUser(id: Long, updateUserRequest: UpdateUserRequest): UserResponse
}