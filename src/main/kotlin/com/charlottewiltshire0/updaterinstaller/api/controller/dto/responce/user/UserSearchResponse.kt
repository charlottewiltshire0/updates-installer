package com.charlottewiltshire0.updaterinstaller.api.controller.dto.responce.user

data class UserSearchResponse(
    val start: Int,
    val limit: Int,
    val length: Int,
    val total: Long,
    val users: List<UserResponse>
)