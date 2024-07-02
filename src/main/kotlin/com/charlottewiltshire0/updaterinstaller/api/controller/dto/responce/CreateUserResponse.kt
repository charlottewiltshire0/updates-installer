package com.charlottewiltshire0.updaterinstaller.api.controller.dto.responce

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class CreateUserResponse(
    @JsonProperty("user_id")
    val userId: Long,

    @JsonProperty("username")
    val username: String,

    @JsonProperty("created_at")
    val createAt: LocalDateTime,

    @JsonProperty("updated_at")
    val updatedAt: LocalDateTime
)
