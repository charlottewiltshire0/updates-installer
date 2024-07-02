package com.charlottewiltshire0.updaterinstaller.api.service.user

import com.charlottewiltshire0.updaterinstaller.api.controller.dto.request.user.CreateUserRequest
import com.charlottewiltshire0.updaterinstaller.api.controller.dto.request.user.UpdateUserRequest
import com.charlottewiltshire0.updaterinstaller.api.controller.dto.responce.user.UserResponse
import com.charlottewiltshire0.updaterinstaller.api.controller.dto.responce.user.UserSearchResponse

interface UserService {

    fun createUser(createUserRequest: CreateUserRequest): UserResponse

    fun getUserById(id: Long): UserResponse

    fun deleteUserById(id: Long): String

    fun updateUser(id: Long, updateUserRequest: UpdateUserRequest): UserResponse

    fun searchUser(
        q: String?,
        sort: String?,
        fields: String?,
        includeFields: Boolean,
        page: Int,
        perPage: Int
    ): UserSearchResponse
}